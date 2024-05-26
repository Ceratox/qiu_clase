package co.edu.uco.qiu.config.controller.response;

import java.util.ArrayList;

import co.edu.uco.qiu.config.dto.organizaciones.CiudadDTO;

public class CiudadResponse extends Response<CiudadDTO> {
	
	public CiudadResponse()
	{
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
