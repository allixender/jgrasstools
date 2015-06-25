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
import org.jgrasstools.modules.Profile; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module creating profiles over rasters.")
public class ProfileAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(ProfileAlgorithm.class); 

  public ProfileAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "The raster map to use for the profile", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String incoordinates;

  @LiteralDataInput(identifier = "inCoordinates", abstrakt = "Comma separated list of easting,northing coordinates to trace the profile on (optional).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinCoordinates(String incoordinates) { 
    this.incoordinates = incoordinates;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector;

  @LiteralDataInput(identifier = "inVector", abstrakt = "Line vector map to use to trace the profile on (optional).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector(String invector) { 
    this.invector = invector;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String flineid;

  @LiteralDataInput(identifier = "fLineid", abstrakt = "The id of the line to use for the name of the profile output file name (used in case of inVector use).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfLineid(String flineid) { 
    this.flineid = flineid;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfolder
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outfolder;

  @LiteralDataInput(identifier = "outFolder", abstrakt = "The folder in which to place the output profiles if multiple (used in case of inVector use).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutFolder(String outfolder) { 
    this.outfolder = outfolder;
  }

  private String res_outfolder;

  @LiteralDataOutput(identifier = "res_outFolder", abstrakt = "The folder in which to place the output profiles if multiple (used in case of inVector use).", binding = LiteralStringBinding.class)
  public String getRes_outFolder() { 
    return res_outfolder;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = double[][]
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outprofile;

  @LiteralDataOutput(identifier = "res_outProfile", abstrakt = "The output profile for the last line read (contains progressive, elevation, x, y).", binding = LiteralStringBinding.class)
  public String getRes_outProfile() { 
    return res_outprofile;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.ProfileAlgorithm");
    
    Profile tmpModule = new Profile(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outFolder",  (String) outfolder); 
    logger.info("outFolder " + ( (String) outfolder) );
    inputs.put("fLineid",  (String) flineid); 
    logger.info("fLineid " + ( (String) flineid) );
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("inCoordinates",  (String) incoordinates); 
    logger.info("inCoordinates " + ( (String) incoordinates) );
    inputs.put("inVector",  (String) invector); 
    logger.info("inVector " + ( (String) invector) );
    
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
    outputs.put("outProfile", "String"); 
    
    res_outfolder = (String) outfolder; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outFolder")) { 
            // and put them into the output result variables 
            res_outfolder = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outProfile")) { 
            // and put them into the output result variables 
            res_outprofile = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

