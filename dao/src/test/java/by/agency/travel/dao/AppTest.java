package by.agency.travel.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.agency.travel.dao.config.DataConfig;
import by.agency.travel.dao.pojo.RolePojo;
import by.agency.travel.dao.pojo.UserPojo;
import by.agency.travel.dao.repository.RoleRepository;
import by.agency.travel.dao.repository.UserRepository;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class AppTest 
{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
 
    @Before
    public void setUp() throws Exception {
        
    }
    
    @Test
    public void testFindUserByLogin() {
    	List<RolePojo> roles = new ArrayList<>();
    	RolePojo role = new RolePojo(2, "user");
    	roles.add(role);
    	UserPojo user = new UserPojo(2, "login@gmail.com", "$2a$10$NMtnFdeQxIrvuNBfjVOTfeOjGiwgnFw4PBekOmp8CnSmN1uzXUXQi", roles);
    	UserPojo userInDB = userRepository.findUserByLogin("login@gmail.com");
    	Assert.assertEquals(user, userInDB);
    }
    
    @Test
    public void testFindRoleByName() {
    	RolePojo role = new RolePojo(2, "user");
    	RolePojo roleInDB = roleRepository.findRoleByName("user");
    	Assert.assertEquals(role, roleInDB);
    } 
}
