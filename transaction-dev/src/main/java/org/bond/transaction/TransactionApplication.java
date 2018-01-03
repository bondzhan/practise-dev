/**   
* @Title: TransactionApplication.java 
* @Package org.bond.transaction 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author bond
* @date 2017��11��30�� ����11:36:23 
* @company ��Ȩ���� �����������ƹ�Ӧ�����޹�˾
* @version V1.0   
*/
package org.bond.transaction;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = "org.bond.transaction")
@MapperScan(basePackages = "org.bond.transaction.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = false)
//@Aspect
@EnableRetry
public class TransactionApplication {
	Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TransactionApplication.class, args);
	}

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource masterSourceConfig() {
		logger.info("init datasource");
		return new DataSource();
	}

	@Bean(name = "transactionManager")
	@DependsOn("dataSource")
	public DataSourceTransactionManager transactionManager(DataSource dataSource) throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "sqlSessionFactory")
	@DependsOn("dataSource")
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Throwable {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean.getObject();
	}

//	@Bean(name = "txAdvice")
//	@DependsOn("transactionManager")
//	public TransactionInterceptor txAdvice(PlatformTransactionManager transactionManager) {
//		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
//
//		/* 只读事务，不做更新操作 */
//		RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
//		readOnlyTx.setReadOnly(true);
//		readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
//
//		/* 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务 */
//		RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
//		requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
//		requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		requiredTx.setTimeout(5);
//
//		Map<String, TransactionAttribute> txMap = new HashMap<>();
//		txMap.put("add*", requiredTx);
//		txMap.put("save*", requiredTx);
//		txMap.put("insert*", requiredTx);
//		txMap.put("update*", requiredTx);
//		txMap.put("delete*", requiredTx);
//		txMap.put("get*", readOnlyTx);
//		txMap.put("query*", readOnlyTx);
//		source.setNameMap(txMap);
//		TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);
//		return txAdvice;
//	}
//
//	@Bean
//	public DefaultAdvisorAutoProxyCreator defaultPointcutAdvisor() {
//		DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//		autoProxyCreator.setInterceptorNames("txAdvice");
//		autoProxyCreator.setProxyTargetClass(true);
//		autoProxyCreator.setExposeProxy(true);
//		return autoProxyCreator;
//	}
//
//	@Bean
//	public Advisor txAdviceAdvisor(TransactionInterceptor transactionInterceptor) {
//		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//		pointcut.setExpression("execution (* org.bond.transaction.service.*.*(..))");
//		return new DefaultPointcutAdvisor(pointcut, transactionInterceptor);
//	}

}
