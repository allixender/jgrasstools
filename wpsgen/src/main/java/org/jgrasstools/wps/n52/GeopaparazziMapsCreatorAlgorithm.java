/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.n52; 
 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
import java.io.*; 
 
import oms3.Access; 
import oms3.ComponentAccess; 
import oms3.annotations.Execute; 
import oms3.annotations.Finalize; 
import oms3.annotations.Initialize; 
 
import org.n52.wps.server.AbstractAnnotatedAlgorithm;
import org.n52.wps.algorithm.annotation.*; 
 
import org.n52.wps.io.data.binding.literal.*; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
import org.geotools.process.ProcessException; 
import org.jgrasstools.modules.GeopaparazziMapsCreator; 
 
@Algorithm(version = "1.0.0", abstrakt = "A map creator for geopaparazzi.")
public class GeopaparazziMapsCreatorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(GeopaparazziMapsCreatorAlgorithm.class); 

  public GeopaparazziMapsCreatorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inroi;

  @LiteralDataInput(identifier = "inROI", abstrakt = "Area of interest shapefile.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinROI(String inroi) { 
    this.inroi = inroi;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inzoomlimitroi;

  @LiteralDataInput(identifier = "inZoomLimitROI", abstrakt = "Zoom limit area shapefile.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinZoomLimitROI(String inzoomlimitroi) { 
    this.inzoomlimitroi = inzoomlimitroi;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster1;

  @LiteralDataInput(identifier = "inRaster1", abstrakt = "Optional input raster map 1.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster1(String inraster1) { 
    this.inraster1 = inraster1;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster2;

  @LiteralDataInput(identifier = "inRaster2", abstrakt = "Optional input raster map 2.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster2(String inraster2) { 
    this.inraster2 = inraster2;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector1;

  @LiteralDataInput(identifier = "inVector1", abstrakt = "Optional input vector map 1.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector1(String invector1) { 
    this.invector1 = invector1;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector2;

  @LiteralDataInput(identifier = "inVector2", abstrakt = "Optional input vector map 2.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector2(String invector2) { 
    this.invector2 = invector2;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector3;

  @LiteralDataInput(identifier = "inVector3", abstrakt = "Optional input vector map 3.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector3(String invector3) { 
    this.invector3 = invector3;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector4;

  @LiteralDataInput(identifier = "inVector4", abstrakt = "Optional input vector map 4.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector4(String invector4) { 
    this.invector4 = invector4;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector5;

  @LiteralDataInput(identifier = "inVector5", abstrakt = "Optional input vector map 5.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector5(String invector5) { 
    this.invector5 = invector5;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pname;

  @LiteralDataInput(identifier = "pName", abstrakt = "Dataset name", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpName(String pname) { 
    this.pname = pname;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pminzoom;

  @LiteralDataInput(identifier = "pMinZoom", abstrakt = "Min zoom level.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMinZoom(int pminzoom) { 
    this.pminzoom = pminzoom;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmaxzoom;

  @LiteralDataInput(identifier = "pMaxZoom", abstrakt = "Max zoom level.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMaxZoom(int pmaxzoom) { 
    this.pmaxzoom = pmaxzoom;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pzoomlimit;

  @LiteralDataInput(identifier = "pZoomLimit", abstrakt = "Zoom limit.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpZoomLimit(int pzoomlimit) { 
    this.pzoomlimit = pzoomlimit;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo: png,jpg
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pimagetype;

  @LiteralDataInput(identifier = "pImageType", abstrakt = "Image type.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpImageType(String pimagetype) { 
    this.pimagetype = pimagetype;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfolder
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outfolder;

  @LiteralDataInput(identifier = "outFolder", abstrakt = "The output folder.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutFolder(String outfolder) { 
    this.outfolder = outfolder;
  }

  private String res_outfolder;

  @LiteralDataOutput(identifier = "res_outFolder", abstrakt = "The output folder.", binding = LiteralStringBinding.class)
  public String getRes_outFolder() { 
    return res_outfolder;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.GeopaparazziMapsCreatorAlgorithm");
    
    GeopaparazziMapsCreator tmpModule = new GeopaparazziMapsCreator(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inRaster2",  (String) inraster2); 
    logger.info("inRaster2 " + ( (String) inraster2) );
    inputs.put("pMinZoom",  (int) pminzoom); 
    logger.info("pMinZoom " + ( (int) pminzoom) );
    inputs.put("pZoomLimit",  (int) pzoomlimit); 
    logger.info("pZoomLimit " + ( (int) pzoomlimit) );
    inputs.put("pImageType",  (String) pimagetype); 
    logger.info("pImageType " + ( (String) pimagetype) );
    inputs.put("outFolder",  (String) outfolder); 
    logger.info("outFolder " + ( (String) outfolder) );
    inputs.put("inVector5",  (String) invector5); 
    logger.info("inVector5 " + ( (String) invector5) );
    inputs.put("inVector4",  (String) invector4); 
    logger.info("inVector4 " + ( (String) invector4) );
    inputs.put("pName",  (String) pname); 
    logger.info("pName " + ( (String) pname) );
    inputs.put("inROI",  (String) inroi); 
    logger.info("inROI " + ( (String) inroi) );
    inputs.put("inVector1",  (String) invector1); 
    logger.info("inVector1 " + ( (String) invector1) );
    inputs.put("inVector3",  (String) invector3); 
    logger.info("inVector3 " + ( (String) invector3) );
    inputs.put("inZoomLimitROI",  (String) inzoomlimitroi); 
    logger.info("inZoomLimitROI " + ( (String) inzoomlimitroi) );
    inputs.put("inVector2",  (String) invector2); 
    logger.info("inVector2 " + ( (String) invector2) );
    inputs.put("pMaxZoom",  (int) pmaxzoom); 
    logger.info("pMaxZoom " + ( (int) pmaxzoom) );
    inputs.put("inRaster1",  (String) inraster1); 
    logger.info("inRaster1 " + ( (String) inraster1) );
    
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.setInputData(inputs, tmpModule, uLog); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Execute.class, false); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    
    // get the results 
    HashMap<String, String> outputs = new HashMap<String, String>();
    ComponentAccess cA = new ComponentAccess(tmpModule); 
    Collection<Access> outputsCollection = cA.outputs(); 
    
    outputs.put("outFolder", "String"); 
    
    res_outfolder = (String) outfolder; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outFolder")) { 
            // and put them into the output result variables 
            res_outfolder = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

