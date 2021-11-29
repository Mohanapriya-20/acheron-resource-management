package org.arm.resource.mngt.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.arm.resource.mngt.entity.Resource;
import org.arm.resource.mngt.service.ResourceService;
import org.arm.resource.mngt.vo.ResourceMapper;
import org.arm.resource.mngt.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@GetMapping("/resource/list")
	public List<Resource> getResources(){
		List<Resource> resList= resourceService.findAll();
		System.out.println(resList.get(0).getAvailability());
		return resList;
		
	}
	
//	@PostMapping("/resource/create")
//	public void createResource(){
//		Resource resource = new Resource();
//		//resource.setAvailability("Available");
//		resource.setCreateDate(new Timestamp(new Date().getTime()));
//		resource.setIsDeleted(0);
//		resource.setResourceName("T User 2");
//		resource.setResourceType("B");
//		
//		resourceService.save(resource);
//	}
	@GetMapping("/resources")
	public List<ResourceVO> getAllResource()
	{
		List<ResourceVO> resourceVO=new ArrayList<ResourceVO>();
		List<Resource> resourceList=resourceService.findAll();
		for(Resource resource:resourceList) {
			ResourceMapper mapper=ResourceMapper.INSTANCE;
			ResourceVO vo=mapper.fromResource(resource);
			resourceVO.add(vo);
		}
		return resourceVO;
	} 
	
	
} 
