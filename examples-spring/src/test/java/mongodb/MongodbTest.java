package mongodb;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.examples.spring.dao.user.UserDao;
import org.examples.spring.dao.user.impl.UserDaoImpl;
import org.examples.spring.entity.NameEntity;
import org.examples.spring.entity.UserEntity;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MongodbTest {

	public static void main(String[] args) {
		System.out.println("Bootstrapping HelloMongo");

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mongodb-context.xml");
		
		UserDao userDao = context.getBean(UserDaoImpl.class);
		userDao._test();
		
		NameEntity nameEntity = new NameEntity();
		nameEntity.setUsername("张三");
		nameEntity.setNickname("边缘");
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId("1");
		userEntity.setName(nameEntity);
		userEntity.setAge(1);
		userEntity.setBirth(new Date());
		userEntity.setPassword("admin");
		userEntity.setRegionName("北京");
		userEntity.setWorks(1);
		userDao.insert(userEntity);
		userDao.update(userEntity);
		userDao.createCollection();

		List<UserEntity> list = userDao.findList(0, 10);
		for (UserEntity e : list) {
			System.out.println("all - id=" + e.getId() + ", age=" + e.getAge()
					+ ", password=" + e.getPassword() + ", regionName="
					+ e.getRegionName() + ", special="
					+ Arrays.toString(e.getSpecial()) + ", name="
					+ e.getName().getUsername() + "-"
					+ e.getName().getNickname() + ", birth=" + e.getBirth());
		}

		list = userDao.findListByAge(1);
		for (UserEntity e : list) {
			System.out.println("all - id=" + e.getId() + ", age="
					+ e.getAge() + ", password=" + e.getPassword()
					+ ", regionName=" + e.getRegionName() + ", special="
					+ Arrays.toString(e.getSpecial()) + ", name="
					+ e.getName().getUsername() + "-"
					+ e.getName().getNickname() + ", birth=" + e.getBirth());
		}

		UserEntity e = userDao.findOne("1");
		System.out.println("all - id=" + e.getId() + ", age=" + e.getAge()
				+ ", password=" + e.getPassword() + ", regionName="
				+ e.getRegionName() + ", special="
				+ Arrays.toString(e.getSpecial()) + ", name="
				+ e.getName().getUsername() + "-" + e.getName().getNickname()
				+ ", birth=" + e.getBirth());

		e = userDao.findOneByUsername("张三");
		System.out.println("all - id=" + e.getId() + ", age="
				+ e.getAge() + ", password=" + e.getPassword()
				+ ", regionName=" + e.getRegionName() + ", special="
				+ Arrays.toString(e.getSpecial()) + ", name="
				+ e.getName().getUsername() + "-" + e.getName().getNickname()
				+ ", birth=" + e.getBirth());
		
		System.out.println("DONE!");
	}

}
