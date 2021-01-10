/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dtos.BoredDTO;
import dtos.CatFactsDTO;
import dtos.HolidayDTO;
import dtos.MyIPDTO;
import dtos.SpaceDTO;
import dtos.TrumpQuotesDTO;
import java.io.IOException;
import java.util.Collection;
import utils.HttpUtils;

/**
 *
 * @author GRP 5
 */
public class DataFetcherFacade {

    public DataFetcherFacade() {

    }

    //Get Holidays from different years and/or countries.
    public Collection<HolidayDTO> getHolidaysDTO(int year, String countryCode) throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://date.nager.at/api/v2/PublicHolidays/" + year + "/" + countryCode);

        java.lang.reflect.Type collectionType = new TypeToken<Collection<HolidayDTO>>() {
        }.getType();

        Collection<HolidayDTO> enums = gson.fromJson(jasonString, collectionType);
        return enums;

    }
    
    public Collection<HolidayDTO> getHolidaysDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://date.nager.at/api/v2/PublicHolidays/2020/DK");

        java.lang.reflect.Type collectionType = new TypeToken<Collection<HolidayDTO>>() {
        }.getType();

        Collection<HolidayDTO> enums = gson.fromJson(jasonString, collectionType);
        return enums;

    }

    public BoredDTO getBoredDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://www.boredapi.com/api/activity/");
        BoredDTO boredDTO = gson.fromJson(jasonString, BoredDTO.class);

        return boredDTO;
    }

    public CatFactsDTO getCatFactsDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://catfact.ninja/fact");
        CatFactsDTO catFactsDTO = gson.fromJson(jasonString, CatFactsDTO.class);

        return catFactsDTO;
    }

    public MyIPDTO getMyIPDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://api.ipify.org?format=json");
        MyIPDTO myIPDTO = gson.fromJson(jasonString, MyIPDTO.class);

        return myIPDTO;
    }

    public SpaceDTO getSpaceDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("http://api.open-notify.org/astros.json");
        SpaceDTO spaceDTO = gson.fromJson(jasonString, SpaceDTO.class);

        return spaceDTO;
    }

    public TrumpQuotesDTO getTrumpQuotesDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://api.whatdoestrumpthink.com/api/v1/quotes/random");
        TrumpQuotesDTO trumpQuotesDTO = gson.fromJson(jasonString, TrumpQuotesDTO.class);

        return trumpQuotesDTO;
    }
}
