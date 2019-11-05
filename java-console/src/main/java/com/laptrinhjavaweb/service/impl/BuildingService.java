package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.responsitory.IBuildingRepository;
import com.laptrinhjavaweb.responsitory.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import com.mysql.cj.util.StringUtils;

public class BuildingService implements IBuildingService {

	private IBuildingRepository buildingRepository;
	private BuildingConverter buildingConverter;

	public BuildingService() {
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable ) {
		/*
		 * List<BuildingDTO> results = new ArrayList<>(); List<BuildingEntity>
		 * buildingEntities = buildingRepository.findAll(); for (BuildingEntity item :
		 * buildingEntities) {
		 * 
		 * // BuildingDTO buildingDTO = new BuildingDTO(); //
		 * buildingDTO.setName(item.getName()); //
		 * buildingDTO.setStructure(item.getStructure()); results.add(buildingDTO);
		 * 
		 * BuildingDTO buildingDTO1 = buildingConverter.convertToBTO(item);
		 * results.add(buildingDTO1); } return results;
		 */

		// java 8
		Map<String, Object> properties = new HashMap<String,Object>();
		properties.put("name", fieldSearch.getName());
		properties.put("district", fieldSearch.getDistrict());
		
		if(org.apache.commons.lang.StringUtils.isNotBlank(fieldSearch.getBuildingArea())) {
			properties.put("buildingArea", Integer.parseInt(fieldSearch.getBuildingArea()));
		}
		if(org.apache.commons.lang.StringUtils.isNotBlank(fieldSearch.getBuildingArea())) {
			properties.put("numberOfBasement", Integer.parseInt(fieldSearch.getNumberOfBasement()));
		}
		
		

		
		return buildingRepository.findAll(properties, pageable).stream().map(item -> buildingConverter.convertToBTO(item))
				.collect(Collectors.toList());
	}

}
