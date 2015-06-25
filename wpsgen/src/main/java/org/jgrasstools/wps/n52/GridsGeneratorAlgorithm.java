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
import org.jgrasstools.modules.GridsGenerator; 
 
@Algorithm(version = "1.0.0", abstrakt = "Generates grid of lines or polygons.")
public class GridsGeneratorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(GridsGeneratorAlgorithm.class); 

  public GridsGeneratorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector;

  @LiteralDataInput(identifier = "inVector", abstrakt = "Optional vector map from which to take the bounds (if supplied, all other bounds related parameter are ignored). This needs pRows and pCols to be defined.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector(String invector) { 
    this.invector = invector;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "Optional raster map from which to take the bounds (if supplied, all other bounds related parameter are ignored. This needs pRows and pCols to be defined.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double plon;

  @LiteralDataInput(identifier = "pLon", abstrakt = "The lower left longitude (needed if no map is supplied).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpLon(double plon) { 
    this.plon = plon;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double plat;

  @LiteralDataInput(identifier = "pLat", abstrakt = "The lower left latitude (needed if no map is supplied).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpLat(double plat) { 
    this.plat = plat;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pwidth;

  @LiteralDataInput(identifier = "pWidth", abstrakt = "The optional grid cell width.", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpWidth(double pwidth) { 
    this.pwidth = pwidth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pheight;

  @LiteralDataInput(identifier = "pHeight", abstrakt = "The optional grid cell height.", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpHeight(double pheight) { 
    this.pheight = pheight;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int prows;

  @LiteralDataInput(identifier = "pRows", abstrakt = "The number of rows.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpRows(int prows) { 
    this.prows = prows;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pcols;

  @LiteralDataInput(identifier = "pCols", abstrakt = "The number of cols.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpCols(int pcols) { 
    this.pcols = pcols;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pspacing;

  @LiteralDataInput(identifier = "pSpacing", abstrakt = "The vertex spacing to use.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSpacing(Double pspacing) { 
    this.pspacing = pspacing;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo: polygon,line,point
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ptype;

  @LiteralDataInput(identifier = "pType", abstrakt = "The output type.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpType(String ptype) { 
    this.ptype = ptype;
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
  private String outmap;

  @LiteralDataInput(identifier = "outMap", abstrakt = "The grid.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMap(String outmap) { 
    this.outmap = outmap;
  }

  private String res_outmap;

  @LiteralDataOutput(identifier = "res_outMap", abstrakt = "The grid.", binding = LiteralStringBinding.class)
  public String getRes_outMap() { 
    return res_outmap;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.GridsGeneratorAlgorithm");
    
    GridsGenerator tmpModule = new GridsGenerator(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pHeight",  (double) pheight); 
    logger.info("pHeight " + ( (double) pheight) );
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("pWidth",  (double) pwidth); 
    logger.info("pWidth " + ( (double) pwidth) );
    inputs.put("pRows",  (int) prows); 
    logger.info("pRows " + ( (int) prows) );
    inputs.put("pCode",  (String) pcode); 
    logger.info("pCode " + ( (String) pcode) );
    inputs.put("pLat",  (double) plat); 
    logger.info("pLat " + ( (double) plat) );
    inputs.put("pLon",  (double) plon); 
    logger.info("pLon " + ( (double) plon) );
    inputs.put("pCols",  (int) pcols); 
    logger.info("pCols " + ( (int) pcols) );
    inputs.put("inVector",  (String) invector); 
    logger.info("inVector " + ( (String) invector) );
    inputs.put("outMap",  (String) outmap); 
    logger.info("outMap " + ( (String) outmap) );
    inputs.put("pSpacing",  (Double) pspacing); 
    logger.info("pSpacing " + ( (Double) pspacing) );
    inputs.put("pType",  (String) ptype); 
    logger.info("pType " + ( (String) ptype) );
    
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

