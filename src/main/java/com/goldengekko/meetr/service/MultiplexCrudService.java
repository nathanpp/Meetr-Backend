package com.goldengekko.meetr.service;

import com.wadpam.open.mvc.CrudService;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.mardao.core.CursorPage;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author sosandstrom
 */
public class MultiplexCrudService<T extends Object, ID extends Serializable>
        implements CrudService<T, ID> {

    /** Contains either the key, or a JSON map of serviceName-to-keys */
    protected static final ThreadLocal<String> MULTIPLEX_VALUE = new ThreadLocal<String>();
    
    protected static final ObjectMapper MAPPER = new ObjectMapper();
    
    private final String serviceName;
    private HashMap<String, CrudService<T, ID>> multiplexMap;
    private CrudService<T, ID> defaultService;

    public MultiplexCrudService(String serviceName) {
        this.serviceName = serviceName;
    }
    
    /**
     * If multiplex value is a JSON-String Map, it picks the key from map.get(serviceName).
     * @return mapped serviceName key, or just the flat multiplex value
     */
    public String getMultiplexKey() {
        final String value = MULTIPLEX_VALUE.get();
        if (null == serviceName || null == value || null == multiplexMap) {
            return null;
        }
        
        if (value.startsWith("{")) {
            try {
                Map map = MAPPER.readValue(value, Map.class);
                Object key = map.get(serviceName);
                return null != key ? key.toString() : null;
            } catch (IOException ignore) {
            }
        }
        
        return value;
    }
    
    protected CrudService<T, ID> getService() {
        final String key = getMultiplexKey();
        if (null != key && null != multiplexMap) {
            final CrudService<T, ID> service = multiplexMap.get(key);
            if (null != service) {
                return service;
            }
        }
        
        return defaultService;
    }
    
    public static void setMultiplexKey(String key) {
        MULTIPLEX_VALUE.set(key);
    }

    public void setMultiplexMap(HashMap<String, CrudService<T, ID>> multiplexMap) {
        this.multiplexMap = multiplexMap;
    }

    public void setDefaultService(CrudService<T, ID> defaultService) {
        this.defaultService = defaultService;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public T createDomain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ID create(T domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String parentKeyString, ID id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String parentKeyString, Iterable<ID> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportCsv(OutputStream out, Long startDate, Long endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(String parentKeyString, ID id) {
        return getService().get(parentKeyString, id);
    }

    @Override
    public Iterable<T> getByPrimaryKeys(Iterable<ID> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CursorPage<T, ID> getPage(int pageSize, String cursorKey) {
        return getService().getPage(pageSize, cursorKey);
    }

    @Override
    public ID getSimpleKey(T domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getParentKeyString(T domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKeyColumnName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class getPrimaryKeyColumnClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Class> getTypeMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ID update(T domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ID> upsert(Iterable<T> domains) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CursorPage<ID, ID> whatsChanged(Date since, int pageSize, String cursorKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
