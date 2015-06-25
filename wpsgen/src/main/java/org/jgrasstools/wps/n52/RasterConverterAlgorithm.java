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
import org.jgrasstools.modules.RasterConverter; 
 
@Algorithm(version = "1.0.0", abstrakt = "Raster conversion module.")
public class RasterConverterAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(RasterConverterAlgorithm.class); 

  public RasterConverterAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "The input raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_north
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pnorth;

  @LiteralDataInput(identifier = "pNorth", abstrakt = "The north bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpNorth(Double pnorth) { 
    this.pnorth = pnorth;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_south
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double psouth;

  @LiteralDataInput(identifier = "pSouth", abstrakt = "The south bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSouth(Double psouth) { 
    this.psouth = psouth;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_west
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pwest;

  @LiteralDataInput(identifier = "pWest", abstrakt = "The west bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpWest(Double pwest) { 
    this.pwest = pwest;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_east
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double peast;

  @LiteralDataInput(identifier = "pEast", abstrakt = "The east bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpEast(Double peast) { 
    this.peast = peast;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_xres
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pxres;

  @LiteralDataInput(identifier = "pXres", abstrakt = "The requested resolution in x.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpXres(Double pxres) { 
    this.pxres = pxres;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_yres
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pyres;

  @LiteralDataInput(identifier = "pYres", abstrakt = "The requested resolution in y.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpYres(Double pyres) { 
    this.pyres = pyres;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_rows
    // fieldType = Integer
    // fieldBindingType = Int
    // fieldVariableType = Integer
  private Integer prows;

  @LiteralDataInput(identifier = "pRows", abstrakt = "The rows of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpRows(Integer prows) { 
    this.prows = prows;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_cols
    // fieldType = Integer
    // fieldBindingType = Int
    // fieldVariableType = Integer
  private Integer pcols;

  @LiteralDataInput(identifier = "pCols", abstrakt = "The cols of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpCols(Integer pcols) { 
    this.pcols = pcols;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outraster;

  @LiteralDataInput(identifier = "outRaster", abstrakt = "The output raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutRaster(String outraster) { 
    this.outraster = outraster;
  }

  private String res_outraster;

  @LiteralDataOutput(identifier = "res_outRaster", abstrakt = "The output raster.", binding = LiteralStringBinding.class)
  public String getRes_outRaster() { 
    return res_outraster;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.RasterConverterAlgorithm");
    
    RasterConverter tmpModule = new RasterConverter(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pYres",  (Double) pyres); 
    logger.info("pYres " + ( (Double) pyres) );
    inputs.put("pNorth",  (Double) pnorth); 
    logger.info("pNorth " + ( (Double) pnorth) );
    inputs.put("outRaster",  (String) outraster); 
    logger.info("outRaster " + ( (String) outraster) );
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("pSouth",  (Double) psouth); 
    logger.info("pSouth " + ( (Double) psouth) );
    inputs.put("pEast",  (Double) peast); 
    logger.info("pEast " + ( (Double) peast) );
    inputs.put("pRows",  (Integer) prows); 
    logger.info("pRows " + ( (Integer) prows) );
    inputs.put("pCols",  (Integer) pcols); 
    logger.info("pCols " + ( (Integer) pcols) );
    inputs.put("pXres",  (Double) pxres); 
    logger.info("pXres " + ( (Double) pxres) );
    inputs.put("pWest",  (Double) pwest); 
    logger.info("pWest " + ( (Double) pwest) );
    
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
    
    outputs.put("outRaster", "String"); 
    
    res_outraster = (String) outraster; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outRaster")) { 
            // and put them into the output result variables 
            res_outraster = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

