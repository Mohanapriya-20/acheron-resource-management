package org.arm.resource.mngt.service.dataaccess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.repository.TaskRepository;
import org.arm.resource.mngt.service.ITaskServiceImpl;
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
public class TaskServiceImplTest {

	@InjectMocks
	ITaskServiceImpl iTaskServiceImpl;

	@Mock
	TaskRepository  taskRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing Task")
	public void getAllTask() {
		List<Task> task = new ArrayList<>();
		Timestamp timestamp;
//		Task e = new Task(1, "Navin", "Manager", "Custom", Timestamp.valueOf("2020-03-27 09:03:01"),
//				Timestamp.valueOf("2020-04-27 09:03:01"), 0, null);
//		resource.add(e);
//
//		when(resourceRepository.findAll()).thenReturn(resource);
		List<Task> actual = iTaskServiceImpl.getAllTask();

		assertEquals(actual.size(), 1);

	}
	
	@Test
	@DisplayName("Testing Empty List")
	public void  checkEmptyTaskList() {
		List<Task> actual = iTaskServiceImpl.getAllTask();
		assertFalse(actual.isEmpty());
	}

}
