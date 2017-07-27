package com.gjy;

import com.gjy.model.Permission;
import com.gjy.model.Role;
import com.gjy.model.UserAdmin;
import com.gjy.service.user.PermissionService;
import com.gjy.service.user.RoleService;
import com.gjy.service.user.UserAdminService;
import com.gjy.web.util.EncryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GjyApplicationTests {

	@Autowired
    UserAdminService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	PermissionService premissionService;

	@Test
	public void contextLoads() {


			UserAdmin admin = new UserAdmin();
			/*admin.setCreateTime(new Date());
			admin.setDeleted(0);
			admin.setStatus(0);
			admin.setUpdateTime(admin.getCreateTime());
			admin.setRealName("test");
			admin.setUserName("admin");
			admin.setSalt(EncryptUtils.getRandomCharAndNum(16));
			//admin.setPassword(EncryptUtils.md5Hex("123456" + admin.getSalt()));
			userService.insert(admin);*/
	}

	@Test
	public void testAddRole(){

		Role role = new Role();

		/*role.setRoleName("test");
		role.setDeleted(0);
		role.setDesc("测试");
		roleService.insert(role);*/
	}

	@Test
	public void testAddPermission(){

		Permission permission = new Permission();

		/*permission.setAvailable(0);
		permission.setName("首页");
		permission.setParentId(0);
		permission.setParentIds("");
		permission.setUrl("/index");
		permission.setResourceType(0);
		permission.setPermission("*");
		premissionService.insert(permission);*/
	}

}
