package br.com.uniCad.model.dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.MedicRegister;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.MedicRegisterDeserializer;

public class MedicRegisterDao extends AbstractDao<MedicRegister> {

	public MedicRegisterDao() {
		super(MedicRegister.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "registro";
	}

	@Override
	protected AbstractDeserializer<MedicRegister> getDeserializer() {
		// TODO Auto-generated method stub
		return new MedicRegisterDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("local_ocorrencia", "atendimentUnity");
		map.put("profissional_responsavel", "responsible");
		map.put("paciente", "pacient");
		map.put("dt_inicio", "beginDate");
		map.put("dt_fim", "endDate");
		map.put("uni_atendimento", "atendimentUnity");
		map.put("local_ocorrencia", "registerLocal");
		map.put("descricao", "description");
		
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void deleteInheritance(AbstractBean bean) {

	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public MedicRegister getMedicRegisterByPacientId(int id){
		try {
			Connection currentConnection = this.getConnection();
			
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);
			
			Field<Object> field = field("paciente");
			Result<Record> result = query.select().from(table(getTableName())).where(field.equal(id)).fetch();
			
			Record record = result.get(0);
			
			AbstractDeserializer<MedicRegister> deserializer = this.getDeserializer();
			MedicRegister deserializedRecord = deserializer.fromDataBaseRecord(record);
			
			return deserializedRecord;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO: ver se deve ser levanatda um axeceção espécífica para este caso
		return null;
	}
}
