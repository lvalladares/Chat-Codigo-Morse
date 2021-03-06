package com.ucab.javachat.Servidor.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *Desarrollado Por:
 *Ing. Randy F. Amaya
 *Email: randy.amaya@uth.hn
 *
 *www.computrachos.com
 *La Comunidad Donde el Conocimiento Se Comparte!!!
 **/
 
public class CompararImagenes
{
	public static boolean comparar(File imagen1, File imagen2) throws IOException
	{
		boolean iguales = true;
		
		byte[] arreglo_byte1=obtener_Imagen_Byte(imagen1);
		byte[] arreglo_byte2=obtener_Imagen_Byte(imagen2);
		
		if(arreglo_byte1 != null && arreglo_byte2 != null)
		{		
			//Compara si el tamaño de los arreglos es diferente	
			if(arreglo_byte1.length!=arreglo_byte2.length)
			{
				//Si son diferentes los tamaños las imagenes tambien.
				iguales = false;
			}
			else
			{
				for (int i = 0; i<arreglo_byte1.length; i++) 
				{
					//Compara Byte a Byte la Imagen
					if(arreglo_byte1[i]!=arreglo_byte2[i])
					{
						//Si algun Byte es diferente, deja de comparar
						iguales = false;
						break;
					}
				}
			}
		}
		return iguales;
	}
	
	private static byte[] obtener_Imagen_Byte(File n) throws IOException
	{
		// No uso getCannonicalPath para no tener que poner try and catch en toda la función
		File file = n;
        if(!file.exists())
        {
        	System.out.println ("La Imagen No Existe Verifique El Nombre y la Ruta");
        	return null;
        }
 
        FileInputStream fis = null;
        try 
        {
    		fis=new FileInputStream(file);
		}
		catch (Exception ex) 
		{
		}
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try 
        {
            for (int readNum; (readNum = fis.read(buf)) != -1;) 
            {
                bos.write(buf, 0, readNum); 
            }
            fis.close();
        } catch (IOException ex) {
            System.out.println ("Error "+ex);
        }
        byte[] bytes = bos.toByteArray();
        return bytes;
	}
}
