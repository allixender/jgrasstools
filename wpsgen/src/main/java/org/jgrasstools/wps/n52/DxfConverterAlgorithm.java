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
import org.jgrasstools.modules.DxfConverter; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module to convert dxf files to geotools vecotors.")
public class DxfConverterAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(DxfConverterAlgorithm.class); 

  public DxfConverterAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String file;

  @LiteralDataInput(identifier = "file", abstrakt = "The dxf file.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfile(String file) { 
    this.file = file;
  }

    // inputOutputIndicator = input
    // fileIndicator = crs
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pcode;

  @LiteralDataInput(identifier = "pCode", abstrakt = "The code defining the coordinate reference system, composed by authority and code number (ex. EPSG:4328). Applied in the case the file is missing.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpCode(String pcode) { 
    this.pcode = pcode;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pointsvector;

  @LiteralDataInput(identifier = "pointsVector", abstrakt = "The output point vector.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpointsVector(String pointsvector) { 
    this.pointsvector = pointsvector;
  }

  private String res_pointsvector;

  @LiteralDataOutput(identifier = "res_pointsVector", abstrakt = "The output point vector.", binding = LiteralStringBinding.class)
  public String getRes_pointsVector() { 
    return res_pointsvector;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String linevector;

  @LiteralDataInput(identifier = "lineVector", abstrakt = "The output lines vector.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setlineVector(String linevector) { 
    this.linevector = linevector;
  }

  private String res_linevector;

  @LiteralDataOutput(identifier = "res_lineVector", abstrakt = "The output lines vector.", binding = LiteralStringBinding.class)
  public String getRes_lineVector() { 
    return res_linevector;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String polygonvector;

  @LiteralDataInput(identifier = "polygonVector", abstrakt = "The output polygons vector.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpolygonVector(String polygonvector) { 
    this.polygonvector = polygonvector;
  }

  private String res_polygonvector;

  @LiteralDataOutput(identifier = "res_polygonVector", abstrakt = "The output polygons vector.", binding = LiteralStringBinding.class)
  public String getRes_polygonVector() { 
    return res_polygonvector;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.DxfConverterAlgorithm");
    
    DxfConverter tmpModule = new DxfConverter(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("file",  (String) file); 
    logger.info("file " + ( (String) file) );
    inputs.put("lineVector",  (String) linevector); 
    logger.info("lineVector " + ( (String) linevector) );
    inputs.put("polygonVector",  (String) polygonvector); 
    logger.info("polygonVector " + ( (String) polygonvector) );
    inputs.put("pCode",  (String) pcode); 
    logger.info("pCode " + ( (String) pcode) );
    inputs.put("pointsVector",  (String) pointsvector); 
    logger.info("pointsVector " + ( (String) pointsvector) );
    
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
    
    outputs.put("lineVector", "String"); 
    outputs.put("polygonVector", "String"); 
    outputs.put("pointsVector", "String"); 
    
    res_linevector = (String) linevector; 
    res_polygonvector = (String) polygonvector; 
    res_pointsvector = (String) pointsvector; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("lineVector")) { 
            // and put them into the output result variables 
            res_linevector = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("polygonVector")) { 
            // and put them into the output result variables 
            res_polygonvector = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("pointsVector")) { 
            // and put them into the output result variables 
            res_pointsvector = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

