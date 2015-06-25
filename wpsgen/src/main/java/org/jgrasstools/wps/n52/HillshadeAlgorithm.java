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
import org.jgrasstools.modules.Hillshade; 
 
@Algorithm(version = "1.0.0", abstrakt = "This class evalutate the hillshade of a DEM.")
public class HillshadeAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(HillshadeAlgorithm.class); 

  public HillshadeAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The map of the elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pmindiffuse;

  @LiteralDataInput(identifier = "pMinDiffuse", abstrakt = "The minimum value of diffuse insolation between 0 to 1 (default is 0).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpMinDiffuse(double pmindiffuse) { 
    this.pmindiffuse = pmindiffuse;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pazimuth;

  @LiteralDataInput(identifier = "pAzimuth", abstrakt = "The value of the azimuth (default is 360).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpAzimuth(double pazimuth) { 
    this.pazimuth = pazimuth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pelev;

  @LiteralDataInput(identifier = "pElev", abstrakt = "The sun elevation (default is 90).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpElev(double pelev) { 
    this.pelev = pelev;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outhill;

  @LiteralDataInput(identifier = "outHill", abstrakt = "The map of hillshade.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutHill(String outhill) { 
    this.outhill = outhill;
  }

  private String res_outhill;

  @LiteralDataOutput(identifier = "res_outHill", abstrakt = "The map of hillshade.", binding = LiteralStringBinding.class)
  public String getRes_outHill() { 
    return res_outhill;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.HillshadeAlgorithm");
    
    Hillshade tmpModule = new Hillshade(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pMinDiffuse",  (double) pmindiffuse); 
    logger.info("pMinDiffuse " + ( (double) pmindiffuse) );
    inputs.put("pAzimuth",  (double) pazimuth); 
    logger.info("pAzimuth " + ( (double) pazimuth) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("pElev",  (double) pelev); 
    logger.info("pElev " + ( (double) pelev) );
    inputs.put("outHill",  (String) outhill); 
    logger.info("outHill " + ( (String) outhill) );
    
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
    
    outputs.put("outHill", "String"); 
    
    res_outhill = (String) outhill; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outHill")) { 
            // and put them into the output result variables 
            res_outhill = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

