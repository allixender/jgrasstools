/*
 * JGrass - Free Open Source Java GIS http://www.jgrass.org 
 * (C) HydroloGIS - www.hydrologis.com 
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Library General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Library General Public License
 * along with this library; if not, write to the Free Foundation, Inc., 59
 * Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.jgrasstools.gears.utils.geometry;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.atan;
import static java.lang.Math.toDegrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.geotools.referencing.GeodeticCalculator;
import org.jgrasstools.gears.libs.monitor.DummyProgressMonitor;
import org.jgrasstools.gears.utils.math.NumericsUtilities;
import org.jgrasstools.gears.utils.sorting.QuickSortAlgorithm;
import org.opengis.feature.type.GeometryType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineSegment;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 * Utilities related to {@link Geometry}.
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 */
public class GeometryUtilities {

    /**
     * Geometry types used by the utility.
     */
    public static enum GEOMETRYTYPE {
        POINT, MULTIPOINT, LINE, MULTILINE, POLYGON, MULTIPOLYGON, UNKNOWN
    }

    private static GeometryFactory geomFactory;
    private static PrecisionModel precModel;

    public static PrecisionModel basicPrecisionModel() {
        return (pm());
    }

    public static GeometryFactory gf() {
        if (geomFactory == null) {
            geomFactory = new GeometryFactory(pm());
        }
        return (geomFactory);
    }

    public static PrecisionModel pm() {
        if (precModel == null) {
            precModel = new PrecisionModel(PrecisionModel.FLOATING);
        }
        return (precModel);
    }

    /**
     * Create a simple polygon (no holes).
     * 
     * @param coords the coords of the polygon.
     * @return the {@link Polygon}.
     */
    public static Polygon createSimplePolygon( Coordinate[] coords ) {
        LinearRing linearRing = gf().createLinearRing(coords);
        return gf().createPolygon(linearRing, null);
    }

    /**
     * Creates a polygon that may help out as placeholder.
     * 
     * @return a dummy {@link Polygon}.
     */
    public static Polygon createDummyPolygon() {
        Coordinate[] c = new Coordinate[]{new Coordinate(0.0, 0.0), new Coordinate(1.0, 1.0), new Coordinate(1.0, 0.0),
                new Coordinate(0.0, 0.0)};
        LinearRing linearRing = gf().createLinearRing(c);
        return gf().createPolygon(linearRing, null);
    }

    public static Polygon createPolygonFromEnvelope( Envelope env ) {
        Coordinate[] c = new Coordinate[]{new Coordinate(env.getMinX(), env.getMinY()),
                new Coordinate(env.getMinX(), env.getMaxY()), new Coordinate(env.getMaxX(), env.getMaxY()),
                new Coordinate(env.getMaxX(), env.getMinY()), new Coordinate(env.getMinX(), env.getMinY())};
        LinearRing linearRing = gf().createLinearRing(c);
        return gf().createPolygon(linearRing, null);
    }

    /**
     * Calculates the angle between two {@link LineSegment}s.
     * 
     * @param l1 the first segment.
     * @param l2 the second segment.
     * @return the angle between the two segments, starting from the first segment 
     *                  moving clockwise.
     */
    public static double angleBetween( LineSegment l1, LineSegment l2 ) {
        double azimuth1 = azimuth(l1.p0, l1.p1);
        double azimuth2 = azimuth(l2.p0, l2.p1);

        if (azimuth1 < azimuth2) {
            return azimuth2 - azimuth1;
        } else {
            return 360 - azimuth1 + azimuth2;
        }
    }

    /**
     * Calculates the azimuth in degrees given two {@link Coordinate} composing a line.
     * 
     * Note that the coords order is important and will differ of 180.
     * 
     * @param c1 first coordinate (used as origin).
     * @param c2 second coordinate.
     * @return the azimuth angle.
     */
    public static double azimuth( Coordinate c1, Coordinate c2 ) {
        // vertical
        if (c1.x == c2.x) {
            if (c1.y == c2.y) {
                // same point
                return Double.NaN;
            } else if (c1.y < c2.y) {
                return 0.0;
            } else if (c1.y > c2.y) {
                return 180.0;
            }
        }
        // horiz
        if (c1.y == c2.y) {
            if (c1.x < c2.x) {
                return 90.0;
            } else if (c1.x > c2.x) {
                return 270.0;
            }
        }
        // -> /
        if (c1.x < c2.x && c1.y < c2.y) {
            double tanA = (c2.x - c1.x) / (c2.y - c1.y);
            double atan = atan(tanA);
            return toDegrees(atan);
        }
        // -> \
        if (c1.x < c2.x && c1.y > c2.y) {
            double tanA = (c1.y - c2.y) / (c2.x - c1.x);
            double atan = atan(tanA);
            return toDegrees(atan) + 90.0;
        }
        // <- /
        if (c1.x > c2.x && c1.y > c2.y) {
            double tanA = (c1.x - c2.x) / (c1.y - c2.y);
            double atan = atan(tanA);
            return toDegrees(atan) + 180;
        }
        // <- \
        if (c1.x > c2.x && c1.y < c2.y) {
            double tanA = (c2.y - c1.y) / (c1.x - c2.x);
            double atan = atan(tanA);
            return toDegrees(atan) + 270;
        }

        return Double.NaN;
    }

    /**
     * Returns the {@link GEOMETRYTYPE} for a given {@link Geometry}. 
     * 
     * @param geometry the geometry to check.
     * @return the type.
     */
    public static GEOMETRYTYPE getGeometryType( Geometry geometry ) {
        if (geometry instanceof LineString) {
            return GEOMETRYTYPE.LINE;
        } else if (geometry instanceof MultiLineString) {
            return GEOMETRYTYPE.MULTILINE;
        } else if (geometry instanceof Point) {
            return GEOMETRYTYPE.POINT;
        } else if (geometry instanceof MultiPoint) {
            return GEOMETRYTYPE.MULTIPOINT;
        } else if (geometry instanceof Polygon) {
            return GEOMETRYTYPE.POLYGON;
        } else if (geometry instanceof MultiPolygon) {
            return GEOMETRYTYPE.MULTIPOLYGON;
        } else {
            return null;
        }
    }

    /**
     * Returns the {@link GEOMETRYTYPE} for a given {@link GeometryType}. 
     * 
     * @param geometryType the geometry type to check.
     * @return the type.
     */
    public static GEOMETRYTYPE getGeometryType( GeometryType geometryType ) {
        Class< ? > binding = geometryType.getBinding();

        if (binding == LineString.class) {
            return GEOMETRYTYPE.LINE;
        } else if (binding == MultiLineString.class) {
            return GEOMETRYTYPE.MULTILINE;
        } else if (binding == Point.class) {
            return GEOMETRYTYPE.POINT;
        } else if (binding == MultiPoint.class) {
            return GEOMETRYTYPE.MULTIPOINT;
        } else if (binding == Polygon.class) {
            return GEOMETRYTYPE.POLYGON;
        } else if (binding == MultiPolygon.class) {
            return GEOMETRYTYPE.MULTIPOLYGON;
        } else {
            return null;
        }
    }

    /**
     * Checks if the given geometry is a {@link LineString} (or {@link MultiLineString}) geometry.
     * 
     * @param geometry the geometry to check.
     * @return <code>true</code> if there are lines in there.
     */
    public static boolean isLine( Geometry geometry ) {
        if (geometry instanceof LineString || geometry instanceof MultiLineString) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the given geometry is a {@link Polygon} (or {@link MultiPolygon}) geometry.
     * 
     * @param geometry the geometry to check.
     * @return <code>true</code> if there are polygons in there.
     */
    public static boolean isPolygon( Geometry geometry ) {
        if (geometry instanceof Polygon || geometry instanceof MultiPolygon) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the given geometry is a {@link Point} (or {@link MultiPoint}) geometry.
     * 
     * @param geometry the geometry to check.
     * @return <code>true</code> if there are points in there.
     */
    public static boolean isPoint( Geometry geometry ) {
        if (geometry instanceof Point || geometry instanceof MultiPoint) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the area of a polygon from its vertices.
     * 
     * @param x the array of x coordinates.
     * @param y the array of y coordinates.
     * @param N the number of sides of the polygon.
     * @return the area of the polygon.
     */
    public static double getPolygonArea( int[] x, int[] y, int N ) {
        int i, j;
        double area = 0;

        for( i = 0; i < N; i++ ) {
            j = (i + 1) % N;
            area += x[i] * y[j];
            area -= y[i] * x[j];
        }

        area /= 2;
        return (area < 0 ? -area : area);
    }

    /**
     * Calculates the 3d distance between two coordinates that have an elevation information.
     * 
     * <p>Note that the {@link Coordinate#distance(Coordinate)} method does only 2d.
     * 
     * @param c1 coordinate 1.
     * @param c2 coordinate 2.
     * @param geodeticCalculator If supplied it will be used for planar distance calculation.
     * @return the distance considering also elevation.
     */
    public static double distance3d( Coordinate c1, Coordinate c2, GeodeticCalculator geodeticCalculator ) {
        if (Double.isNaN(c1.z) || Double.isNaN(c2.z)) {
            throw new IllegalArgumentException("Missing elevation information in the supplied coordinates.");
        }
        double deltaElev = Math.abs(c1.z - c2.z);
        double projectedDistance;
        if (geodeticCalculator != null) {
            geodeticCalculator.setStartingGeographicPoint(c1.x, c1.y);
            geodeticCalculator.setDestinationGeographicPoint(c2.x, c2.y);
            projectedDistance = geodeticCalculator.getOrthodromicDistance();
        } else {
            projectedDistance = c1.distance(c2);
        }

        double distance = NumericsUtilities.pythagoras(projectedDistance, deltaElev);
        return distance;
    }

    public static void sortHorizontal( Coordinate[] coordinates ) {
        QuickSortAlgorithm sorter = new QuickSortAlgorithm(new DummyProgressMonitor());

        double[] x = new double[coordinates.length];
        double[] y = new double[coordinates.length];
        for( int i = 0; i < x.length; i++ ) {
            x[i] = coordinates[i].x;
            y[i] = coordinates[i].y;
        }

        sorter.sort(x, y);

        for( int i = 0; i < x.length; i++ ) {
            coordinates[i].x = x[i];
            coordinates[i].y = y[i];
        }
    }

    /**
     * Joins two lines to a polygon.
     * 
     * @param checkValid checks if the resulting polygon is valid.
     * @param lines the lines to use.
     * @return the joined polygon or <code>null</code> if something ugly happened. 
     */
    public static Polygon lines2Polygon( boolean checkValid, LineString... lines ) {
        List<Coordinate> coordinatesList = new ArrayList<Coordinate>();

        List<LineString> linesList = new ArrayList<LineString>();
        for( LineString tmpLine : lines ) {
            linesList.add(tmpLine);
        }

        LineString currentLine = linesList.get(0);
        linesList.remove(0);
        while( linesList.size() > 0 ) {
            Coordinate[] coordinates = currentLine.getCoordinates();
            List<Coordinate> tmpList = Arrays.asList(coordinates);
            coordinatesList.addAll(tmpList);

            Point thePoint = currentLine.getEndPoint();

            double minDistance = Double.MAX_VALUE;
            LineString minDistanceLine = null;
            boolean needFlip = false;
            for( LineString tmpLine : linesList ) {
                Point tmpStartPoint = tmpLine.getStartPoint();
                double distance = thePoint.distance(tmpStartPoint);
                if (distance < minDistance) {
                    minDistance = distance;
                    minDistanceLine = tmpLine;
                    needFlip = false;
                }

                Point tmpEndPoint = tmpLine.getEndPoint();
                distance = thePoint.distance(tmpEndPoint);
                if (distance < minDistance) {
                    minDistance = distance;
                    minDistanceLine = tmpLine;
                    needFlip = true;
                }
            }

            linesList.remove(minDistanceLine);

            if (needFlip) {
                minDistanceLine = (LineString) minDistanceLine.reverse();
            }

            currentLine = minDistanceLine;

        }
        // add last
        Coordinate[] coordinates = currentLine.getCoordinates();
        List<Coordinate> tmpList = Arrays.asList(coordinates);
        coordinatesList.addAll(tmpList);

        coordinatesList.add(coordinatesList.get(0));
        LinearRing linearRing = gf().createLinearRing(coordinatesList.toArray(new Coordinate[0]));
        Polygon polygon = gf().createPolygon(linearRing, null);

        if (checkValid) {
            if (!polygon.isValid()) {
                return null;
            }
        }
        return polygon;
    }

}
