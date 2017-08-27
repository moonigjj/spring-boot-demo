package com.gjy;

import com.gjy.model.*;
import com.gjy.service.resource.ResourceService;
import com.gjy.service.role.RolePermissionService;
import com.gjy.service.user.PermissionService;
import com.gjy.service.user.RoleService;
import com.gjy.service.user.UserAdminService;
import com.gjy.web.util.EncryptUtils;
import com.gjy.web.util.GsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GjyApplicationTests {

	@Autowired
    UserAdminService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	PermissionService premissionService;

	@Autowired
	RolePermissionService rolePermissionService;

	@Autowired
	ResourceService resourceService;

	@Test
	public void contextLoads() {


			UserAdmin admin = new UserAdmin();
			admin.setDeleted(0);
			admin.setStatus(0);
			admin.setRealName("高家杨");
			admin.setUserName("gjy");
			admin.setSalt(EncryptUtils.getRandomCharAndNum(16));
			admin.setPassword(EncryptUtils.md5Hex("123456", admin.getSalt()));
			userService.insertAllColumn(admin);
	}

	@Test
	public void testAddRole(){

		Role role = new Role();

		role.setName("admin");
		role.setDeleted(0);
		role.setRemark("超级管理员");
		roleService.insertAllColumn(role);
	}

	@Test
	public void testAddUseRole(){

		UserAdmin userAdmin = this.userService.findByName("gjy");
		Role role = this.roleService.selectById(1);
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		boolean isSuc = this.userService.addRole(roles, userAdmin);
		System.out.printf("add result:" + isSuc);
	}

	@Test
	public void testAddRolePermission(){

		RolePermission rolePermission = new RolePermission();
		rolePermission.setRoleId(2);
		rolePermission.setDeleted(0);
		rolePermission.setPermission("user:view");
		rolePermissionService.insertAllColumn(rolePermission);
	}

	@Test
	public void testAddPermission(){

		Permission permission = new Permission();
		permission.setName("del");
		permission.setRemark("删除");
		premissionService.insertAllColumn(permission);
	}

	@Test
	public void testFindByRoleId(){

		Integer[] ids = new Integer[]{1};
		List<RolePermission> lists = rolePermissionService.findByRoleIds(ids);
		System.out.printf(GsonUtils.toJson(lists));
	}


	@Test
	public void testFindUser(){

		UserAdmin userAdmin = userService.findByName("gjy");
		System.out.printf("user admin >>> " + GsonUtils.toJson(userAdmin));
	}

	@Test
	public void testAddResource(){

		Resource resource = new Resource();
		resource.setName("system");
		resource.setRemark("系统管理");
		resource.setDeleted(0);
		resource.setUrl("#");
		resourceService.insertAllColumn(resource);
	}

}
