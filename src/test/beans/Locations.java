/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.beans;

import test.beans.Geo_Loc;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aragab
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations implements Serializable {

    private String _id;
    private String type;
    private String name;
    private Geo_Loc geo_position;

    /**
     * @return the _id
     */
    public String get_id() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(String _id) {
        this._id = _id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the geo_position
     */
    public Geo_Loc getGeo_position() {
        return geo_position;
    }

    /**
     * @param geo_position the geo_position to set
     */
    public void setGeo_position(Geo_Loc geo_position) {
        this.geo_position = geo_position;
    }

    /**
     * @return the name
     */
}
