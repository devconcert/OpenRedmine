package jp.redmine.redmineclient.entity;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class RedmineStatus implements IMasterRecord {
	public final static String ID = "id";
	public final static String CONNECTION = "connection_id";
	public final static String STATUS_ID = "status_id";
	public final static String NAME = "name";

    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField(uniqueIndexName="status_target")
    private Integer connection_id;
    @DatabaseField(uniqueIndexName="status_target")
    private int status_id;
    @DatabaseField
    private String name;
    @DatabaseField
    private boolean is_default;
    @DatabaseField
    private boolean is_close;
    @DatabaseField
    private Date created;
    @DatabaseField
    private Date modified;


    @Override
    public String toString(){
    	return name;
    }


    /**
	 * @param id セットする id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	////////////////////////////////////////////////////////
	/**
	 * @param name セットする 名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return name 名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param connection セットする connection
	 */
	public void setRedmineConnection(RedmineConnection connection) {
		this.setConnectionId(connection.getId());
	}
	/**
	 * @param created セットする created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param modified セットする modified
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
	/**
	 * @return modified
	 */
	public Date getModified() {
		return modified;
	}


	/**
	 * @param is_default セットする is_default
	 */
	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}


	/**
	 * @return is_default
	 */
	public boolean isIs_default() {
		return is_default;
	}


	/**
	 * @param is_close セットする is_close
	 */
	public void setIs_close(boolean is_close) {
		this.is_close = is_close;
	}


	/**
	 * @return is_close
	 */
	public boolean isIs_close() {
		return is_close;
	}


	/**
	 * @param status_id セットする status_id
	 */
	public void setStatusId(int status_id) {
		this.status_id = status_id;
	}


	/**
	 * @return status_id
	 */
	public Integer getStatusId() {
		return status_id;
	}


	/**
	 * @param connection_id セットする connection_id
	 */
	public void setConnectionId(Integer connection_id) {
		this.connection_id = connection_id;
	}


	/**
	 * @return connection_id
	 */
	public Integer getConnectionId() {
		return connection_id;
	}


	@Override
	public void setRemoteId(Long id) {
		if(id == null)
			return;
		setStatusId(id.intValue());
	}


	@Override
	public Long getRemoteId() {
		return (getStatusId() == null) ? null : (long)getStatusId();
	}

}
