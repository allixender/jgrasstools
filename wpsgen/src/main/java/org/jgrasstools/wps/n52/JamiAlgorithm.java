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
import org.jgrasstools.modules.Jami; 
 
@Algorithm(version = "1.0.0", abstrakt = "Jami - Just another meteo interpolator")
public class JamiAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(JamiAlgorithm.class); 

  public JamiAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String instations;

  @LiteralDataInput(identifier = "inStations", abstrakt = "The features representing the meteo stations and containing the position information as well as the elevation. Every feature has a unique id that is used to map the meteo data records to it.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinStations(String instations) { 
    this.instations = instations;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fstationid;

  @LiteralDataInput(identifier = "fStationid", abstrakt = "The field name of the attribute table that holds the station id.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfStationid(String fstationid) { 
    this.fstationid = fstationid;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fstationelev;

  @LiteralDataInput(identifier = "fStationelev", abstrakt = "The field name of the attribute table that holds the station elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfStationelev(String fstationelev) { 
    this.fstationelev = fstationelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pbins;

  @LiteralDataInput(identifier = "pBins", abstrakt = "The bins into which to divide the vertical range of stations in order to define levels.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpBins(int pbins) { 
    this.pbins = pbins;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pnum;

  @LiteralDataInput(identifier = "pNum", abstrakt = "The minimum number of stations required at a certain level, to perform interpolation.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpNum(int pnum) { 
    this.pnum = pnum;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ininterpolate;

  @LiteralDataInput(identifier = "inInterpolate", abstrakt = "The features representing the points in which the meteo data will be interpolated to. The baricenter of the basin is used to place the result ofthe interpolation. These can be of any shape, the baricenter will be used anyways.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinInterpolate(String ininterpolate) { 
    this.ininterpolate = ininterpolate;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fbasinid;

  @LiteralDataInput(identifier = "fBasinid", abstrakt = "The field name of the attribute table that holds the basin id.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfBasinid(String fbasinid) { 
    this.fbasinid = fbasinid;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int ptype;

  @LiteralDataInput(identifier = "pType", abstrakt = "The meteo type that will be handled for interpolation [0 = temp, 1 = pressure, 2 = humidity, 3 = wind, 4 = DTDAY, 5 = DTMONTH].", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpType(int ptype) { 
    this.ptype = ptype;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = %
  private double defaultrh;

  @LiteralDataInput(identifier = "defaultRh", abstrakt = "The default value for relative humidity: 70%", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultRh(double defaultrh) { 
    this.defaultrh = defaultrh;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m/s
  private double defaultw;

  @LiteralDataInput(identifier = "defaultW", abstrakt = "The default value for wind speed: 1 m/s", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultW(double defaultw) { 
    this.defaultw = defaultw;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = hours
  private double phtmin;

  @LiteralDataInput(identifier = "pHtmin", abstrakt = "The hour of the day in which Tmin is supposed to happen.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpHtmin(double phtmin) { 
    this.phtmin = phtmin;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = hours
  private double phtmax;

  @LiteralDataInput(identifier = "pHtmax", abstrakt = "The hour of the day in which Tmax is supposed to happen.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpHtmax(double phtmax) { 
    this.phtmax = phtmax;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = celsius degrees
  private double defaultdtday;

  @LiteralDataInput(identifier = "defaultDtday", abstrakt = "Dayly temperature range.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultDtday(double defaultdtday) { 
    this.defaultdtday = defaultdtday;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = celsius degrees
  private double defaultdtmonth;

  @LiteralDataInput(identifier = "defaultDtmonth", abstrakt = "Monthly temperature range.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultDtmonth(double defaultdtmonth) { 
    this.defaultdtmonth = defaultdtmonth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = hours
  private double defaulttolltmin;

  @LiteralDataInput(identifier = "defaultTolltmin", abstrakt = "Number of hours of tollerance in Tmin", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultTolltmin(double defaulttolltmin) { 
    this.defaulttolltmin = defaulttolltmin;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = hours
  private double defaulttolltmax;

  @LiteralDataInput(identifier = "defaultTolltmax", abstrakt = "Number of hours of tollerance in Tmax", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setdefaultTolltmax(double defaulttolltmax) { 
    this.defaulttolltmax = defaulttolltmax;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inaltimetry;

  @LiteralDataInput(identifier = "inAltimetry", abstrakt = "The list of altimetric bands information, into which the basin is divided.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinAltimetry(String inaltimetry) { 
    this.inaltimetry = inaltimetry;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inareas;

  @LiteralDataInput(identifier = "inAreas", abstrakt = "The list of altimetric/energetic bands areas.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinAreas(String inareas) { 
    this.inareas = inareas;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmeteo;

  @LiteralDataInput(identifier = "inMeteo", abstrakt = "The map of meteo data to interpolate. Every value is associated to the id of the station.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMeteo(String inmeteo) { 
    this.inmeteo = inmeteo;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outinterpolatedband;

  @LiteralDataInput(identifier = "outInterpolatedBand", abstrakt = "Output interpolated meteo data for every band and point. Every value is associated to the id of the interpolation point.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutInterpolatedBand(String outinterpolatedband) { 
    this.outinterpolatedband = outinterpolatedband;
  }

  private String res_outinterpolatedband;

  @LiteralDataOutput(identifier = "res_outInterpolatedBand", abstrakt = "Output interpolated meteo data for every band and point. Every value is associated to the id of the interpolation point.", binding = LiteralStringBinding.class)
  public String getRes_outInterpolatedBand() { 
    return res_outinterpolatedband;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outinterpolated;

  @LiteralDataInput(identifier = "outInterpolated", abstrakt = "Output interpolated meteo data for every point. Every value is associated to the id of the interpolation point.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutInterpolated(String outinterpolated) { 
    this.outinterpolated = outinterpolated;
  }

  private String res_outinterpolated;

  @LiteralDataOutput(identifier = "res_outInterpolated", abstrakt = "Output interpolated meteo data for every point. Every value is associated to the id of the interpolation point.", binding = LiteralStringBinding.class)
  public String getRes_outInterpolated() { 
    return res_outinterpolated;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.JamiAlgorithm");
    
    Jami tmpModule = new Jami(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("defaultTolltmin",  (double) defaulttolltmin); 
    logger.info("defaultTolltmin " + ( (double) defaulttolltmin) );
    inputs.put("fStationelev",  (String) fstationelev); 
    logger.info("fStationelev " + ( (String) fstationelev) );
    inputs.put("defaultRh",  (double) defaultrh); 
    logger.info("defaultRh " + ( (double) defaultrh) );
    inputs.put("defaultDtmonth",  (double) defaultdtmonth); 
    logger.info("defaultDtmonth " + ( (double) defaultdtmonth) );
    inputs.put("inAreas",  (String) inareas); 
    logger.info("inAreas " + ( (String) inareas) );
    inputs.put("fStationid",  (String) fstationid); 
    logger.info("fStationid " + ( (String) fstationid) );
    inputs.put("outInterpolatedBand",  (String) outinterpolatedband); 
    logger.info("outInterpolatedBand " + ( (String) outinterpolatedband) );
    inputs.put("defaultTolltmax",  (double) defaulttolltmax); 
    logger.info("defaultTolltmax " + ( (double) defaulttolltmax) );
    inputs.put("pBins",  (int) pbins); 
    logger.info("pBins " + ( (int) pbins) );
    inputs.put("defaultDtday",  (double) defaultdtday); 
    logger.info("defaultDtday " + ( (double) defaultdtday) );
    inputs.put("inStations",  (String) instations); 
    logger.info("inStations " + ( (String) instations) );
    inputs.put("pNum",  (int) pnum); 
    logger.info("pNum " + ( (int) pnum) );
    inputs.put("defaultW",  (double) defaultw); 
    logger.info("defaultW " + ( (double) defaultw) );
    inputs.put("pHtmin",  (double) phtmin); 
    logger.info("pHtmin " + ( (double) phtmin) );
    inputs.put("inInterpolate",  (String) ininterpolate); 
    logger.info("inInterpolate " + ( (String) ininterpolate) );
    inputs.put("inAltimetry",  (String) inaltimetry); 
    logger.info("inAltimetry " + ( (String) inaltimetry) );
    inputs.put("fBasinid",  (String) fbasinid); 
    logger.info("fBasinid " + ( (String) fbasinid) );
    inputs.put("pHtmax",  (double) phtmax); 
    logger.info("pHtmax " + ( (double) phtmax) );
    inputs.put("inMeteo",  (String) inmeteo); 
    logger.info("inMeteo " + ( (String) inmeteo) );
    inputs.put("outInterpolated",  (String) outinterpolated); 
    logger.info("outInterpolated " + ( (String) outinterpolated) );
    inputs.put("pType",  (int) ptype); 
    logger.info("pType " + ( (int) ptype) );
    
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
    
    outputs.put("outInterpolated", "String"); 
    outputs.put("outInterpolatedBand", "String"); 
    
    res_outinterpolated = (String) outinterpolated; 
    res_outinterpolatedband = (String) outinterpolatedband; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outInterpolated")) { 
            // and put them into the output result variables 
            res_outinterpolated = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outInterpolatedBand")) { 
            // and put them into the output result variables 
            res_outinterpolatedband = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

