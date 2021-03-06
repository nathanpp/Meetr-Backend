package com.goldengekko.meetr.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.sf.mardao.core.CursorPage;
import net.sf.mardao.core.dao.Dao;
import com.goldengekko.meetr.domain.DmFile;
import net.sf.mardao.core.geo.DLocation;

/**
 * DAO interface with finder methods for DmFile entities.
 *
 * Generated on 2013-07-08T16:37:00.829+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public interface GeneratedDmFileDao extends Dao<DmFile, java.lang.Long> {

	/** Column name for primary key attribute is "id" */
	static final String COLUMN_NAME_ID = "id";


	/** Column name for field createdBy is "createdBy" */
	static final String COLUMN_NAME_CREATEDBY = "createdBy";
	/** Column name for field createdDate is "createdDate" */
	static final String COLUMN_NAME_CREATEDDATE = "createdDate";
	/** Column name for field extRef is "extRef" */
	static final String COLUMN_NAME_EXTREF = "extRef";
	/** Column name for field name is "name" */
	static final String COLUMN_NAME_NAME = "name";
	/** Column name for field updatedBy is "updatedBy" */
	static final String COLUMN_NAME_UPDATEDBY = "updatedBy";
	/** Column name for field updatedDate is "updatedDate" */
	static final String COLUMN_NAME_UPDATEDDATE = "updatedDate";

	/** The list of attribute names */
	static final List<String> COLUMN_NAMES = Arrays.asList(		COLUMN_NAME_CREATEDBY,
		COLUMN_NAME_CREATEDDATE,
		COLUMN_NAME_EXTREF,
		COLUMN_NAME_NAME,
		COLUMN_NAME_UPDATEDBY,
		COLUMN_NAME_UPDATEDDATE);
	/** The list of Basic attribute names */
	static final List<String> BASIC_NAMES = Arrays.asList(		COLUMN_NAME_CREATEDBY,
		COLUMN_NAME_CREATEDDATE,
		COLUMN_NAME_EXTREF,
		COLUMN_NAME_NAME,
		COLUMN_NAME_UPDATEDBY,
		COLUMN_NAME_UPDATEDDATE);
	/** The list of attribute names */
	static final List<String> MANY_TO_ONE_NAMES = Arrays.asList();


	// ----------------------- field finders -------------------------------
	/**
	 * query-by method for field createdBy
	 * @param createdBy the specified attribute
	 * @return an Iterable of DmFiles for the specified createdBy
	 */
	Iterable<DmFile> queryByCreatedBy(java.lang.String createdBy);
		
	/**
	 * query-keys-by method for field createdBy
	 * @param createdBy the specified attribute
	 * @return an Iterable of DmFiles for the specified createdBy
	 */
	Iterable<java.lang.Long> queryKeysByCreatedBy(java.lang.String createdBy);

	/**
	 * query-page-by method for field createdBy
	 * @param createdBy the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DmFiles for the specified createdBy
	 */
	CursorPage<DmFile, java.lang.Long> queryPageByCreatedBy(java.lang.String createdBy,
            int pageSize, String cursorString);


	/**
	 * query-by method for field createdDate
	 * @param createdDate the specified attribute
	 * @return an Iterable of DmFiles for the specified createdDate
	 */
	Iterable<DmFile> queryByCreatedDate(java.util.Date createdDate);
		
	/**
	 * query-keys-by method for field createdDate
	 * @param createdDate the specified attribute
	 * @return an Iterable of DmFiles for the specified createdDate
	 */
	Iterable<java.lang.Long> queryKeysByCreatedDate(java.util.Date createdDate);

	/**
	 * query-page-by method for field createdDate
	 * @param createdDate the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DmFiles for the specified createdDate
	 */
	CursorPage<DmFile, java.lang.Long> queryPageByCreatedDate(java.util.Date createdDate,
            int pageSize, String cursorString);


	/**
	 * query-by method for field extRef
	 * @param extRef the specified attribute
	 * @return an Iterable of DmFiles for the specified extRef
	 */
	Iterable<DmFile> queryByExtRef(java.lang.String extRef);
		
	/**
	 * query-keys-by method for field extRef
	 * @param extRef the specified attribute
	 * @return an Iterable of DmFiles for the specified extRef
	 */
	Iterable<java.lang.Long> queryKeysByExtRef(java.lang.String extRef);

	/**
	 * query-page-by method for field extRef
	 * @param extRef the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DmFiles for the specified extRef
	 */
	CursorPage<DmFile, java.lang.Long> queryPageByExtRef(java.lang.String extRef,
            int pageSize, String cursorString);


	/**
	 * query-by method for field name
	 * @param name the specified attribute
	 * @return an Iterable of DmFiles for the specified name
	 */
	Iterable<DmFile> queryByName(java.lang.String name);
		
	/**
	 * query-keys-by method for field name
	 * @param name the specified attribute
	 * @return an Iterable of DmFiles for the specified name
	 */
	Iterable<java.lang.Long> queryKeysByName(java.lang.String name);

	/**
	 * query-page-by method for field name
	 * @param name the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DmFiles for the specified name
	 */
	CursorPage<DmFile, java.lang.Long> queryPageByName(java.lang.String name,
            int pageSize, String cursorString);


	/**
	 * query-by method for field updatedBy
	 * @param updatedBy the specified attribute
	 * @return an Iterable of DmFiles for the specified updatedBy
	 */
	Iterable<DmFile> queryByUpdatedBy(java.lang.String updatedBy);
		
	/**
	 * query-keys-by method for field updatedBy
	 * @param updatedBy the specified attribute
	 * @return an Iterable of DmFiles for the specified updatedBy
	 */
	Iterable<java.lang.Long> queryKeysByUpdatedBy(java.lang.String updatedBy);

	/**
	 * query-page-by method for field updatedBy
	 * @param updatedBy the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DmFiles for the specified updatedBy
	 */
	CursorPage<DmFile, java.lang.Long> queryPageByUpdatedBy(java.lang.String updatedBy,
            int pageSize, String cursorString);


	/**
	 * query-by method for field updatedDate
	 * @param updatedDate the specified attribute
	 * @return an Iterable of DmFiles for the specified updatedDate
	 */
	Iterable<DmFile> queryByUpdatedDate(java.util.Date updatedDate);
		
	/**
	 * query-keys-by method for field updatedDate
	 * @param updatedDate the specified attribute
	 * @return an Iterable of DmFiles for the specified updatedDate
	 */
	Iterable<java.lang.Long> queryKeysByUpdatedDate(java.util.Date updatedDate);

	/**
	 * query-page-by method for field updatedDate
	 * @param updatedDate the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DmFiles for the specified updatedDate
	 */
	CursorPage<DmFile, java.lang.Long> queryPageByUpdatedDate(java.util.Date updatedDate,
            int pageSize, String cursorString);


		  
	// ----------------------- one-to-one finders -------------------------

	// ----------------------- many-to-one finders -------------------------
	
	// ----------------------- many-to-many finders -------------------------

	// ----------------------- uniqueFields finders -------------------------
	
	
	// ----------------------- populate / persist method -------------------------

	/**
	 * Persist an entity given all attributes
	 */
	DmFile persist(		java.lang.Long id, 
		java.lang.String extRef, 
		java.lang.String name);	

}
