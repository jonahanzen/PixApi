package br.com.pix;

import java.util.HashMap;

import org.json.JSONObject;

import br.com.gerencianet.Credentials;
import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;

public class ListarCobrancas {

	 public JSONObject consultaGeral() {
	        Credentials credentials = new Credentials();

	        JSONObject options = new JSONObject();
	        options.put("client_id", credentials.getClientId());
	        options.put("client_secret", credentials.getClientSecret());
	        options.put("pix_cert", credentials.getCertificadoPix());
	        options.put("sandbox", credentials.isSandbox());

	        HashMap<String, String> params = new HashMap<String, String>();
	        params.put("inicio", "2021-10-10T00:00:00Z");
	        params.put("fim", "2021-12-12T23:59:59Z");

	        try {
	            Gerencianet gn = new Gerencianet(options);
	            JSONObject response = gn.call("pixListCharges", params, new JSONObject());
	            return response;
	        } catch (GerencianetException e) {
	            System.out.println(e.getError());
	            System.out.println(e.getErrorDescription());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	
	
	
}
