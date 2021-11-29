package org.arm.resource.mngt.service.dataaccess;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.arm.resource.mngt.entity.Resource;
import org.arm.resource.mngt.repository.ResourceRepository;
import org.arm.resource.mngt.service.ResourceService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ResourceServiceImplTest {

	@InjectMocks
	ResourceService resourceService;

	@Mock
	ResourceRepository resourceRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing Resource")
	public void getAllResources() {
		List<Resource> resource = new ArrayList<>();
		Timestamp timestamp;
//		Resource e = new Resource(1, "Navin", "Manager", "Custom", Timestamp.valueOf("2020-03-27 09:03:01"),
//				Timestamp.valueOf("2020-04-27 09:03:01"), 0, null);
//		resource.add(e);

		when(resourceRepository.findAll()).thenReturn(resource);
		List<Resource> actual = resourceService.findAll();

		assertEquals(actual.size(), 1);

	}
	
	

}
