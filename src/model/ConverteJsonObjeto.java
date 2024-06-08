package model;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;

public class ConverteJsonObjeto {

    public static EnderecoDTO converter(String respostaAPI) {
        Gson gson = new Gson();

        try {
            return gson.fromJson(respostaAPI, EnderecoDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
