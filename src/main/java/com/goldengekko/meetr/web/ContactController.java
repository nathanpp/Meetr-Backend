/**
 *     Copyright 2012, 2013 Golden Gekko
 *
 *     This file is part of Meetr.
 *
 *     Meetr is free software: you can use it, modify it and / or
 *     redistribute it as is or with your changes under the terms of the
 *     GNU General Public License as published by the Free Software
 *     Foundation, either version 3 of the License, or (at your option)
 *     any later version.
 *
 *     Meetr is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Meetr.  If not, see <http://www.gnu.org/licenses />.
 */
package com.goldengekko.meetr.web;


import javax.servlet.http.HttpServletRequest;

import net.sf.mardao.core.CursorPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldengekko.meetr.domain.DmContact;
import com.goldengekko.meetr.json.JContact;
import com.goldengekko.meetr.service.salesforce.SalesforceService;
import com.wadpam.oauth2.domain.DConnection;
import com.wadpam.open.mvc.CrudController;
import com.wadpam.open.mvc.CrudService;
import com.wadpam.open.security.SecurityInterceptor;

/**
 * 
 * @author sosandstrom
 */
@Controller
@RequestMapping("{domain}/contact")
public class ContactController extends CrudController<JContact, DmContact, String, CrudService<DmContact, String>> {
    
    private SalesforceService salesforceService;

    @ModelAttribute(value = "token")
    public DConnection populateToken(HttpServletRequest request) {

        final DConnection conn = (DConnection) request.getAttribute(SecurityInterceptor.AUTH_PARAM_OAUTH);

        // if present on the request, set the ThreadLocal in the service:
        if (null != conn) {
            salesforceService.setToken(conn.getAccessToken());
            salesforceService.setAppArg0(conn.getAppArg0());
        }
        return conn;
    }
    
    @RequestMapping(value="v10/all", method= RequestMethod.GET)
    @ResponseBody
    public Integer fetchAll(@RequestParam(defaultValue = "199") int pageSize) {
        int count = 0;
        
        CursorPage<DmContact, String> page;
        String cursorKey = null;
        do {
            page = service.getPage(pageSize, cursorKey);
            cursorKey = page.getCursorKey();
            count += page.getItems().size();
            LOG.info("fetched page with cursorKey {}, count={}", cursorKey, count);
        } while (null != cursorKey);
        return count;
    }

//    @RequestMapping(value = "v10", method = RequestMethod.GET, params = {"searchText"})
//    @ResponseBody
//    public JCursorPage<JContact> search(@RequestParam String searchText, @RequestParam(defaultValue = "10") int pageSize,
//            @RequestParam(required = false) Serializable cursorKey) {
//
//        final CursorPage<DmContact, String> page = service.searchContacts(searchText, pageSize, cursorKey);
//        final JCursorPage body = convertPage(page);
//
//        return body;
//    }

    // ----------------- Converter and setters ---------------------------------

    public ContactController() {
        super(JContact.class);
    }

    @Override
    public void convertDomain(DmContact from, JContact to) {
        to.setCreatedBy(from.getCreatedBy());
        to.setCreatedDate(toLong(from.getCreatedDate()));
        to.setUpdatedBy(from.getUpdatedBy());
        to.setUpdatedDate(toLong(from.getUpdatedDate()));
        to.setId(from.getId());

        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setPhone(from.getPhone());
        to.setMobilePhone(from.getMobilePhone());

        // convert Address
        to.setStreet(from.getStreet());
        to.setCityArea(from.getCityArea());
        to.setCity(from.getCity());
        to.setCounty(from.getCounty());
        to.setPostalCode(from.getPostalCode());
        to.setCountry(from.getCountry());
    }

    @Override
    public void convertJson(JContact from, DmContact to) {
        to.setCreatedBy(from.getCreatedBy());
        to.setCreatedDate(toDate(from.getCreatedDate()));
        to.setUpdatedBy(from.getUpdatedBy());
        to.setUpdatedDate(toDate(from.getUpdatedDate()));
        to.setId(from.getId());

        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setPhone(from.getPhone());
        to.setMobilePhone(from.getMobilePhone());

        // convert Address
        to.setStreet(from.getStreet());
        to.setCityArea(from.getCityArea());
        to.setCity(from.getCity());
        to.setCounty(from.getCounty());
        to.setPostalCode(from.getPostalCode());
        to.setCountry(from.getCountry());
    }

    public void setSalesforceService(SalesforceService salesforceService) {
        this.salesforceService = salesforceService;
    }

}
