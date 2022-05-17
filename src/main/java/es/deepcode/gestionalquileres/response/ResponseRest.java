/**
 * 
 */
package es.deepcode.gestionalquileres.response;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author aocarballo
 *
 */
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class ResponseRest {
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();
	public ArrayList<HashMap<String, String>> getMetadata(){
		return metadata;
	}
	public void setMetadata(String tipo,String codigo,String date){
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("tipo", tipo);
		mapa.put("codigo", codigo);
		mapa.put("date", date);
		
		metadata.add(mapa);
	}
}
