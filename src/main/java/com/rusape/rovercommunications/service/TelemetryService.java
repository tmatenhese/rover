package com.rusape.rovercommunications.service;

import java.util.List;
import java.util.Map;

import com.rusape.rovercommunications.model.Martian;
import com.rusape.rovercommunications.model.MartianObject;
import com.rusape.rovercommunications.model.TelemetryMessage;

public interface TelemetryService {
	public TelemetryMessage findById(Long id);
	public List<TelemetryMessage> findByAll();
	public TelemetryMessage save(TelemetryMessage initializationMessage);
	public TelemetryMessage processTelemetry(String initializationMessage);
	public List<MartianObject> processMartianObjectMessage(Map<Character,String> martianObject,TelemetryMessage telemetryMessage);
	public List<Martian> processMartinEnemy(String enemy,TelemetryMessage telemetryMessage);
	public List<MartianObject> saveAllObjects(List<MartianObject> martianObjects);
	public List<Martian> saveAllEnemies(List<Martian> martians);
}
