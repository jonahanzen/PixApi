package br.com.pix;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mifmif.common.regex.Generex;

import br.com.gerencianet.Credentials;
import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;


public class CriarCobranca {
	
	 public JSONObject criarCobrancaDados(String nome, String cpf, String valor) {
	        String txid;
	        Generex generex = new Generex("[a-zA-Z0-9]{26,35}");
	        txid = generex.random();
	        Credentials credentials = new Credentials();

	        JSONObject options = new JSONObject();
	        options.put("client_id", credentials.getClientId());
	        options.put("client_secret", credentials.getClientSecret());
	        options.put("pix_cert", credentials.getCertificadoPix());
	        options.put("sandbox", credentials.isSandbox());

	        HashMap<String, String> params = new HashMap<String, String>();
	        params.put("txid", txid);

	        JSONObject body = new JSONObject();
	        body.put("calendario", new JSONObject().put("expiracao", 3600));
	        body.put("devedor", new JSONObject().put("cpf", cpf).put("nome", nome));
	        body.put("valor", new JSONObject().put("original", valor));
	        body.put("chave", "SUA CHAVE PIX");
	        body.put("solicitacaoPagador", "Serviço realizado.");

	        JSONArray infoAdicionais = new JSONArray();
	        infoAdicionais.put(new JSONObject().put("nome", "Campo 1").put("valor", "Informação Adicional1 do PSP-Recebedor"));
	        infoAdicionais.put(new JSONObject().put("nome", "Campo 2").put("valor", "Informação Adicional2 do PSP-Recebedor"));
	        body.put("infoAdicionais", infoAdicionais);

	        try {
	            Gerencianet gn = new Gerencianet(options);
	            JSONObject response = gn.call("pixCreateCharge", params, body);
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
