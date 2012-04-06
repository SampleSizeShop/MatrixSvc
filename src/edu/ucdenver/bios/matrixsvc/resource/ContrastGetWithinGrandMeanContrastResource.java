/*
 * Matrix Service for the GLIMMPSE Software System.  Processes
 * incoming HTTP requests for matrix operations like addition, substraction
 * kronecker multiplication and so on
 * Copyright (C) 2010 Regents of the University of Colorado.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301, USA.
 */
package edu.ucdenver.bios.matrixsvc.resource;

import java.util.ArrayList;

import org.restlet.resource.Post;

import edu.ucdenver.bios.webservice.common.domain.NamedMatrix;
import edu.ucdenver.bios.webservice.common.domain.RepeatedMeasuresNode;

/**
 * 
 * @author VIJAY AKULA
 *
 */
public interface ContrastGetWithinGrandMeanContrastResource {
    /**
     * Return a polynomial contrast to test the grand mean for the specified
     * list of factors.
     * 
     * @param fullFactorList
     *            The fullFactorList is the ArrayList of RepeatedMeasuresNode
     *            objects which are to be converted to Factor Objects and a full
     *            contrast collection is generated using this fullFactorList.
     * 
     * @return NamedMatrix Return a polynomial contrast to test the grand mean
     *         for the specified list of which is of type NamedMatrix.
     */
    @Post
    NamedMatrix getWithinGrandMeanContrast(
            ArrayList<RepeatedMeasuresNode> fullFactorList);
}
