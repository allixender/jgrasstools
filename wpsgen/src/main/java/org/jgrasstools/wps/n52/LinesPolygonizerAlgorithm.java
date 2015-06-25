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
import org.jgrasstools.modules.LinesPolygonizer; 
 
@Algorithm(version = "1.0.0", abstrakt = "Polygonizes a layer of lines.")
public class LinesPolygonizerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LinesPolygonizerAlgorithm.class); 

  public LinesPolygonizerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap;

  @LiteralDataInput(identifier = "inMap", abstrakt = "The map of lines to polygonize.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap(String inmap) { 
    this.inmap = inmap;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inpoints;

  @LiteralDataInput(identifier = "inPoints", abstrakt = "The map of points containing the id to put in the polygons attributes (optional).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPoints(String inpoints) { 
    this.inpoints = inpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fid;

  @LiteralDataInput(identifier = "fId", abstrakt = "The field of the points layer containing the id for the polygons (necessary if inPoints is defined).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfId(String fid) { 
    this.fid = fid;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fnewid;

  @LiteralDataInput(identifier = "fNewId", abstrakt = "The field of the polygonized layer containing the id (default is 'id').", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfNewId(String fnewid) { 
    this.fnewid = fnewid;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outmap;

  @LiteralDataInput(identifier = "outMap", abstrakt = "The map of polygons.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMap(String outmap) { 
    this.outmap = outmap;
  }

  private String res_outmap;

  @LiteralDataOutput(identifier = "res_outMap", abstrakt = "The map of polygons.", binding = LiteralStringBinding.class)
  public String getRes_outMap() { 
    return res_outmap;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LinesPolygonizerAlgorithm");
    
    LinesPolygonizer tmpModule = new LinesPolygonizer(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inPoints",  (String) inpoints); 
    logger.info("inPoints " + ( (String) inpoints) );
    inputs.put("fNewId",  (String) fnewid); 
    logger.info("fNewId " + ( (String) fnewid) );
    inputs.put("inMap",  (String) inmap); 
    logger.info("inMap " + ( (String) inmap) );
    inputs.put("fId",  (String) fid); 
    logger.info("fId " + ( (String) fid) );
    inputs.put("outMap",  (String) outmap); 
    logger.info("outMap " + ( (String) outmap) );
    
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
    
    outputs.put("outMap", "String"); 
    
    res_outmap = (String) outmap; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outMap")) { 
            // and put them into the output result variables 
            res_outmap = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

