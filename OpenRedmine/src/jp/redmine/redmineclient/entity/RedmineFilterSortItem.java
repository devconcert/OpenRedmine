package jp.redmine.redmineclient.entity;

import java.util.ArrayList;
import java.util.List;

import jp.redmine.redmineclient.R;

public class RedmineFilterSortItem implements IMasterRecord {
	private long id;
	private String dbKey;
	private String remoteKey;
	private boolean isAscending;
	private int resource;
	private String localname;
	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return dbKey
	 */
	public String getDbKey() {
		return dbKey;
	}
	/**
	 * @param dbKey セットする dbKey
	 */
	public void setDbKey(String dbKey) {
		this.dbKey = dbKey;
	}
	/**
	 * @return remoteKey
	 */
	public String getRemoteKey() {
		return remoteKey;
	}
	/**
	 * @param remoteKey セットする remoteKey
	 */
	public void setRemoteKey(String remoteKey) {
		this.remoteKey = remoteKey;
	}
	/**
	 * @return isAscending
	 */
	public boolean isAscending() {
		return isAscending;
	}
	/**
	 * @param isAscending セットする isAscending
	 */
	public void setAscending(boolean isAscending) {
		this.isAscending = isAscending;
	}
	/**
	 * @return resource
	 */
	public int getResource() {
		return resource;
	}
	/**
	 * @param resource セットする resource
	 */
	public void setResource(int resource) {
		this.resource = resource;
	}
	@Override
	public void setRemoteId(Long id) {
		setId(id);
	}
	@Override
	public Long getRemoteId() {
		return getId();
	}
	@Override
	public void setName(String name) {
		localname = name;
	}
	@Override
	public String getName() {
		return localname;
	}

	public static RedmineFilterSortItem setFilter(RedmineFilterSortItem item, String input){
		String[] keys = input.split(" ");
		boolean isAscending = false;
		if(keys.length >= 2){
			if("desc".equalsIgnoreCase(keys[1]))
				isAscending = false;
			else
				isAscending = true;
		} else {
			isAscending = true;
		}
		if("issue".equals(keys[0])){
			item.setDbKey(RedmineIssue.ISSUE_ID);
			item.setRemoteKey("id");
			item.setResource(R.string.ticket_issue);
		} else if("tracker".equals(keys[0])){
			item.setDbKey("RedmineTracker."+RedmineTracker.NAME);
			item.setRemoteKey("tracker");
			item.setResource(R.string.ticket_tracker);
		} else if("status".equals(keys[0])){
			item.setDbKey("RedmineStatus."+RedmineStatus.NAME);
			item.setRemoteKey("status");
			item.setResource(R.string.ticket_status);
		}

		item.setAscending(isAscending);
		return item;

	}
	public static List<RedmineFilterSortItem> getFilters(boolean isAddDesc){
		List<RedmineFilterSortItem> list = new ArrayList<RedmineFilterSortItem>();
		long id = 0;
		for(String key : new String[]{
				"issue"
				,"tracker"
				,"status"
		}){
			RedmineFilterSortItem item;
			if(isAddDesc){
				item = setFilter(new RedmineFilterSortItem(),key);
				item.setAscending(false);
				item.setId(++id);
				list.add(item);
			}
			item = setFilter(new RedmineFilterSortItem(),key);
			item.setAscending(true);
			item.setId(++id);
			list.add(item);
		}
		return list;
	}


}
