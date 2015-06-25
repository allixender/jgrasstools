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
import org.jgrasstools.modules.Kriging; 
 
@Algorithm(version = "1.0.0", abstrakt = "Ordinary kriging algorithm.")
public class KrigingAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(KrigingAlgorithm.class); 

  public KrigingAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String instations;

  @LiteralDataInput(identifier = "inStations", abstrakt = "The vector of the measurement point, containing the position of the stations.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinStations(String instations) { 
    this.instations = instations;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String indata;

  @LiteralDataInput(identifier = "inData", abstrakt = "The file with the measured data, to be interpolated.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinData(String indata) { 
    this.indata = indata;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ininterpolate;

  @LiteralDataInput(identifier = "inInterpolate", abstrakt = "The vector of the points in which the data have to be interpolated.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinInterpolate(String ininterpolate) { 
    this.ininterpolate = ininterpolate;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ininterpolationgrid;

  @LiteralDataInput(identifier = "inInterpolationGrid", abstrakt = "The collection of the points in which the data needs to be interpolated.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinInterpolationGrid(String ininterpolationgrid) { 
    this.ininterpolationgrid = ininterpolationgrid;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fstationsid;

  @LiteralDataInput(identifier = "fStationsid", abstrakt = "The field of the vector of stations, defining the id.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfStationsid(String fstationsid) { 
    this.fstationsid = fstationsid;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fstationsz;

  @LiteralDataInput(identifier = "fStationsZ", abstrakt = "The field of the vector of stations, defining the elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfStationsZ(String fstationsz) { 
    this.fstationsz = fstationsz;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String finterpolateid;

  @LiteralDataInput(identifier = "fInterpolateid", abstrakt = "The field of the interpolated vector points, defining the id.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfInterpolateid(String finterpolateid) { 
    this.finterpolateid = finterpolateid;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fpointz;

  @LiteralDataInput(identifier = "fPointZ", abstrakt = "The field of the interpolated vector points, defining the elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfPointZ(String fpointz) { 
    this.fpointz = fpointz;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "The interpolation mode (0 = interpolate on irregular grid, 1 = interpolate on regular grid).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMode(int pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pintegralscale;

  @LiteralDataInput(identifier = "pIntegralscale", abstrakt = "The integral scale as comma separated values.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpIntegralscale(String pintegralscale) { 
    this.pintegralscale = pintegralscale;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pvariance;

  @LiteralDataInput(identifier = "pVariance", abstrakt = "The variance.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpVariance(double pvariance) { 
    this.pvariance = pvariance;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dologarithmic;

  @LiteralDataInput(identifier = "doLogarithmic", abstrakt = "Switch for logaritmic run selection.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoLogarithmic(Boolean dologarithmic) { 
    this.dologarithmic = dologarithmic;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double psemivariogramtype;

  @LiteralDataInput(identifier = "pSemivariogramType", abstrakt = "The type of theoretical semivariogram: 0 = Gaussian; 1 = Exponential.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSemivariogramType(double psemivariogramtype) { 
    this.psemivariogramtype = psemivariogramtype;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doincludezero;

  @LiteralDataInput(identifier = "doIncludezero", abstrakt = "Include zeros in computations (default is true).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoIncludezero(Boolean doincludezero) { 
    this.doincludezero = doincludezero;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pa;

  @LiteralDataInput(identifier = "pA", abstrakt = "The range if the models runs with the gaussian variogram.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpA(double pa) { 
    this.pa = pa;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double ps;

  @LiteralDataInput(identifier = "pS", abstrakt = "The sill if the models runs with the gaussian variogram.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpS(double ps) { 
    this.ps = ps;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pnug;

  @LiteralDataInput(identifier = "pNug", abstrakt = "Is the nugget if the models runs with the gaussian variogram.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpNug(double pnug) { 
    this.pnug = pnug;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outgrid;

  @LiteralDataInput(identifier = "outGrid", abstrakt = "The interpolated gridded data (for mode 2 and 3.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutGrid(String outgrid) { 
    this.outgrid = outgrid;
  }

  private String res_outgrid;

  @LiteralDataOutput(identifier = "res_outGrid", abstrakt = "The interpolated gridded data (for mode 2 and 3.", binding = LiteralStringBinding.class)
  public String getRes_outGrid() { 
    return res_outgrid;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outdata;

  @LiteralDataOutput(identifier = "res_outData", abstrakt = "The interpolated data (for mode 0 and 1).", binding = LiteralStringBinding.class)
  public String getRes_outData() { 
    return res_outdata;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.KrigingAlgorithm");
    
    Kriging tmpModule = new Kriging(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outGrid",  (String) outgrid); 
    logger.info("outGrid " + ( (String) outgrid) );
    inputs.put("pSemivariogramType",  (double) psemivariogramtype); 
    logger.info("pSemivariogramType " + ( (double) psemivariogramtype) );
    inputs.put("pS",  (double) ps); 
    logger.info("pS " + ( (double) ps) );
    inputs.put("pIntegralscale",  (String) pintegralscale); 
    logger.info("pIntegralscale " + ( (String) pintegralscale) );
    inputs.put("doLogarithmic",  (Boolean) dologarithmic); 
    logger.info("doLogarithmic " + ( (Boolean) dologarithmic) );
    inputs.put("fStationsid",  (String) fstationsid); 
    logger.info("fStationsid " + ( (String) fstationsid) );
    inputs.put("fStationsZ",  (String) fstationsz); 
    logger.info("fStationsZ " + ( (String) fstationsz) );
    inputs.put("inInterpolationGrid",  (String) ininterpolationgrid); 
    logger.info("inInterpolationGrid " + ( (String) ininterpolationgrid) );
    inputs.put("inStations",  (String) instations); 
    logger.info("inStations " + ( (String) instations) );
    inputs.put("inInterpolate",  (String) ininterpolate); 
    logger.info("inInterpolate " + ( (String) ininterpolate) );
    inputs.put("pNug",  (double) pnug); 
    logger.info("pNug " + ( (double) pnug) );
    inputs.put("doIncludezero",  (Boolean) doincludezero); 
    logger.info("doIncludezero " + ( (Boolean) doincludezero) );
    inputs.put("fInterpolateid",  (String) finterpolateid); 
    logger.info("fInterpolateid " + ( (String) finterpolateid) );
    inputs.put("pMode",  (int) pmode); 
    logger.info("pMode " + ( (int) pmode) );
    inputs.put("pA",  (double) pa); 
    logger.info("pA " + ( (double) pa) );
    inputs.put("fPointZ",  (String) fpointz); 
    logger.info("fPointZ " + ( (String) fpointz) );
    inputs.put("inData",  (String) indata); 
    logger.info("inData " + ( (String) indata) );
    inputs.put("pVariance",  (double) pvariance); 
    logger.info("pVariance " + ( (double) pvariance) );
    
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
    
    outputs.put("outGrid", "String"); 
    outputs.put("outData", "String"); 
    
    res_outgrid = (String) outgrid; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outGrid")) { 
            // and put them into the output result variables 
            res_outgrid = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outData")) { 
            // and put them into the output result variables 
            res_outdata = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

