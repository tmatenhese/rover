package com.rusape.rovercommunications.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rusape.rovercommunications.model.Martian;
import com.rusape.rovercommunications.model.MartianObject;
import com.rusape.rovercommunications.model.TelemetryMessage;
import com.rusape.rovercommunications.pojo.MarsObjectKind;
import com.rusape.rovercommunications.repository.MartianObjectRepository;
import com.rusape.rovercommunications.repository.MartianRepository;
import com.rusape.rovercommunications.repository.TelemetryRepository;
import com.rusape.rovercommunications.service.TelemetryService;

@Service
public class TelemetryServiceImpl implements TelemetryService {
	private static final Logger LOGGER = Logger.getLogger(TelemetryServiceImpl.class.getName());

	@Autowired
	private TelemetryRepository telemetryRepository;
	@Autowired
	private MartianObjectRepository martianObjectRepository;
	@Autowired
	private MartianRepository martianRepository;
	@Override
	public TelemetryMessage findById(Long id) {
		return telemetryRepository.getOne(id);
	}

	@Override
	public List<TelemetryMessage> findByAll() {
		return telemetryRepository.findAll();
	}

	@Override
	public TelemetryMessage save(TelemetryMessage telemetryMessage) {
		return telemetryRepository.save(telemetryMessage);
	}

	@Override
	public TelemetryMessage processTelemetry(String message) {
		TelemetryMessage telemetryMessage = new TelemetryMessage();
		if(telemetryMessage!=null) {
			String[] responseArray = message.split(" ");
			telemetryMessage.setTimeStamp(Integer.parseInt(responseArray[0]));
			telemetryMessage.setVehicleControl(responseArray[1]);
			telemetryMessage.setVehicleXCoordinate(new Float(responseArray[2]));
			telemetryMessage.setVehicleYCoordinate(new Float(responseArray[3]));
			telemetryMessage.setVehicleDirection(new Float(responseArray[4]));
			telemetryMessage.setVehicleSpeed(new Float(responseArray[5]));
			
		}
		return telemetryMessage;
	}

	@Override
	public List<MartianObject> processMartianObjectMessage(Map<Character,String> martianObject,TelemetryMessage telemetryMessage) {
		List<MartianObject> martianObjects = new ArrayList<MartianObject>();
		Character[] objKindArr = new Character[3];
			objKindArr[0]='b';
			objKindArr[1]='c';
			objKindArr[2]='h';
		for(Character objKind:objKindArr) {
			if(martianObject.containsKey(objKind)) {
				String objectKinds = martianObject.get(objKind);
				if(objectKinds!=null) {					
					String[] objectKindArr = objectKinds.split(",");
					for(String objectKind:objectKindArr) {
						MartianObject martianObj = new MartianObject();
						martianObj.setTelemetryMessage(telemetryMessage);						
						String[] objectKindArray = objectKind.split(" ");
						martianObj.setxCoordinate(new Float(objectKindArray[0]));
						martianObj.setyCoordinate(new Float(objectKindArray[1]));
						martianObj.setRadius(new Float(objectKindArray[2]));
						if(objKind=='c') {
							martianObj.setObjectKind(MarsObjectKind.CRATER.name());
						}else if(objKind=='b') {
							martianObj.setObjectKind(MarsObjectKind.BOULDER.name());
						}else if(objKind=='h') {
							martianObj.setObjectKind(MarsObjectKind.HOMEBASE.name());
						}							
						martianObj.setTelemetryMessage(telemetryMessage);
						martianObjects.add(martianObj);
						}
				}
			}			
		}
		return martianObjects;
	}

	@Override
	public List<Martian> processMartinEnemy(String enemy,TelemetryMessage telemetryMessage) {
		List<Martian> martians = new ArrayList<Martian>();
		Martian martian = new Martian();
		if(enemy!=null) {
			String[] enemyArr = enemy.split(",");
			for(String martianEnemy:enemyArr) {
				String[] enemyArray = martianEnemy.split(" ");
				martian.setxCoordinate(new Float(enemyArray[0]));
				martian.setyCoordinate(new Float(enemyArray[1]));
				martian.setDirection(new Float(enemyArray[2]));
				martian.setSpeed(new Float(enemyArray[3]));	
				martian.setTelemetryMessage(telemetryMessage);
				martians.add(martian);
				}
		}
		return martians;
	}

	@Override
	public List<MartianObject> saveAllObjects(List<MartianObject> martianObject) {
		return martianObjectRepository.saveAll(martianObject);
	}

	@Override
	public List<Martian> saveAllEnemies(List<Martian> martians) {
		return martianRepository.saveAll(martians);
	}

}
