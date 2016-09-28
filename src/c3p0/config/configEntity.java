package c3p0.config;
/**
 * 数据库配置实体类
 * @author Administrator
 *
 */
public class configEntity {

	/** 数据库驱动 */
	private String driverClass;
	/** url连接 */
	private String jdbcUrl;
	/** 用户名 */
	private String user;
	/** 密码 */
	private String password;
	/** 初始化连接数 */
	private int initialPoolSize; 
	/** 超时时间 */
	private int maxIdleTime;
	/** 最大连接数 */
	private int maxPoolSize;
	/** 最小连接数 */
	private int minPoolSize;
	/** 最多的数据库语句 */
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
	 * 根据属性对应赋值
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
