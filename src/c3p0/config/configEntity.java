package c3p0.config;
/**
 * ���ݿ�����ʵ����
 * @author Administrator
 *
 */
public class configEntity {

	/** ���ݿ����� */
	private String driverClass;
	/** url���� */
	private String jdbcUrl;
	/** �û��� */
	private String user;
	/** ���� */
	private String password;
	/** ��ʼ�������� */
	private int initialPoolSize; 
	/** ��ʱʱ�� */
	private int maxIdleTime;
	/** ��������� */
	private int maxPoolSize;
	/** ��С������ */
	private int minPoolSize;
	/** �������ݿ���� */
	private int maxStatements;
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getInitialPoolSize() {
		return initialPoolSize;
	}
	public void setInitialPoolSize(int initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}
	public int getMaxIdleTime() {
		return maxIdleTime;
	}
	public void setMaxIdleTime(int maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}
	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
	public int getMinPoolSize() {
		return minPoolSize;
	}
	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}
	public int getMaxStatements() {
		return maxStatements;
	}
	public void setMaxStatements(int maxStatements) {
		this.maxStatements = maxStatements;
	}
	/**
	 * �������Զ�Ӧ��ֵ
	 * @param entity
	 * @param name
	 * @param value
	 */
	public void SetAttributer(configEntity entity,String name,String value){
		switch(name){
		case "driverClass":
			entity.setDriverClass(value);
			break;
		case "jdbcUrl":
			entity.setJdbcUrl(value);
			break;
		case "user":
			entity.setUser(value);
			break;
		case "password":
			entity.setPassword(value);
			break;
		case "initialPoolSize": 
			entity.setInitialPoolSize(Integer.parseInt(value));
			break;
		case "maxIdleTime":
			entity.setMaxIdleTime(Integer.parseInt(value));
			break;
		case "maxPoolSize":
			entity.setMaxPoolSize(Integer.parseInt(value));
			break;
		case "minPoolSize":
			entity.setMinPoolSize(Integer.parseInt(value));
			break;
		case "maxStatements":
			entity.setMaxStatements(Integer.parseInt(value));
			break;
		}
	}
}
