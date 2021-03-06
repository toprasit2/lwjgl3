/*
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package org.lwjgl.util.yoga;

import org.testng.annotations.*;

import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YGAbsolutePositionTest {
	@Test
	public void test_absolute_layout_width_height_start_top() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setWidth(100f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.START, 10f);
		root_child0.setPosition(YogaEdge.TOP, 10f);
		root_child0.setWidth(10f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(80f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_width_height_end_bottom() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setWidth(100f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.END, 10f);
		root_child0.setPosition(YogaEdge.BOTTOM, 10f);
		root_child0.setWidth(10f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(80f, root_child0.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0.getLayoutY(), 0.0f);
		assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child0.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0.getLayoutY(), 0.0f);
		assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_start_top_end_bottom() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setWidth(100f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.START, 10f);
		root_child0.setPosition(YogaEdge.TOP, 10f);
		root_child0.setPosition(YogaEdge.END, 10f);
		root_child0.setPosition(YogaEdge.BOTTOM, 10f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_width_height_start_top_end_bottom() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setWidth(100f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.START, 10f);
		root_child0.setPosition(YogaEdge.TOP, 10f);
		root_child0.setPosition(YogaEdge.END, 10f);
		root_child0.setPosition(YogaEdge.BOTTOM, 10f);
		root_child0.setWidth(10f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(80f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_do_not_clamp_height_of_absolute_node_to_height_of_its_overflow_hidden_parent() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setOverflow(YogaOverflow.HIDDEN);
		root.setWidth(50f);
		root.setHeight(50f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.START, 0f);
		root_child0.setPosition(YogaEdge.TOP, 0f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child0_child0 = new YogaNode(config);
		root_child0_child0.setWidth(100f);
		root_child0_child0.setHeight(100f);
		root_child0.addChildAt(root_child0_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(50f, root.getLayoutWidth(), 0.0f);
		assertEquals(50f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(50f, root.getLayoutWidth(), 0.0f);
		assertEquals(50f, root.getLayoutHeight(), 0.0f);

		assertEquals(-50f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_within_border() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setMargin(YogaEdge.LEFT, 10f);
		root.setMargin(YogaEdge.TOP, 10f);
		root.setMargin(YogaEdge.RIGHT, 10f);
		root.setMargin(YogaEdge.BOTTOM, 10f);
		root.setPadding(YogaEdge.LEFT, 10);
		root.setPadding(YogaEdge.TOP, 10);
		root.setPadding(YogaEdge.RIGHT, 10);
		root.setPadding(YogaEdge.BOTTOM, 10);
		root.setBorder(YogaEdge.LEFT, 10f);
		root.setBorder(YogaEdge.TOP, 10f);
		root.setBorder(YogaEdge.RIGHT, 10f);
		root.setBorder(YogaEdge.BOTTOM, 10f);
		root.setWidth(100f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.LEFT, 0f);
		root_child0.setPosition(YogaEdge.TOP, 0f);
		root_child0.setWidth(50f);
		root_child0.setHeight(50f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode(config);
		root_child1.setPositionType(YogaPositionType.ABSOLUTE);
		root_child1.setPosition(YogaEdge.RIGHT, 0f);
		root_child1.setPosition(YogaEdge.BOTTOM, 0f);
		root_child1.setWidth(50f);
		root_child1.setHeight(50f);
		root.addChildAt(root_child1, 1);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(10f, root.getLayoutX(), 0.0f);
		assertEquals(10f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(40f, root_child1.getLayoutY(), 0.0f);
		assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(10f, root.getLayoutX(), 0.0f);
		assertEquals(10f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(40f, root_child1.getLayoutY(), 0.0f);
		assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_and_justify_content_center() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setJustifyContent(YogaJustify.CENTER);
		root.setAlignItems(YogaAlign.CENTER);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_and_justify_content_flex_end() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setJustifyContent(YogaJustify.FLEX_END);
		root.setAlignItems(YogaAlign.FLEX_END);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child0.getLayoutX(), 0.0f);
		assertEquals(60f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(60f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_justify_content_center() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setJustifyContent(YogaJustify.CENTER);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_center() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setAlignItems(YogaAlign.CENTER);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_center_on_child_only() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setAlignSelf(YogaAlign.CENTER);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_and_justify_content_center_and_top_position() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setJustifyContent(YogaJustify.CENTER);
		root.setAlignItems(YogaAlign.CENTER);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.TOP, 10f);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_and_justify_content_center_and_bottom_position() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setJustifyContent(YogaJustify.CENTER);
		root.setAlignItems(YogaAlign.CENTER);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.BOTTOM, 10f);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(50f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child0.getLayoutX(), 0.0f);
		assertEquals(50f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_and_justify_content_center_and_left_position() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setJustifyContent(YogaJustify.CENTER);
		root.setAlignItems(YogaAlign.CENTER);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.LEFT, 5f);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(5f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(5f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_absolute_layout_align_items_and_justify_content_center_and_right_position() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setJustifyContent(YogaJustify.CENTER);
		root.setAlignItems(YogaAlign.CENTER);
		root.setFlexGrow(1f);
		root.setWidth(110f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode(config);
		root_child0.setPositionType(YogaPositionType.ABSOLUTE);
		root_child0.setPosition(YogaEdge.RIGHT, 5f);
		root_child0.setWidth(60f);
		root_child0.setHeight(40f);
		root.addChildAt(root_child0, 0);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(45f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(110f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(45f, root_child0.getLayoutX(), 0.0f);
		assertEquals(30f, root_child0.getLayoutY(), 0.0f);
		assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child0.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_position_root_with_rtl_should_position_withoutdirection() {
		YogaConfig config = new YogaConfig();

		YogaNode root = new YogaNode(config);
		root.setPosition(YogaEdge.LEFT, 72f);
		root.setWidth(52f);
		root.setHeight(52f);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(72f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(52f, root.getLayoutWidth(), 0.0f);
		assertEquals(52f, root.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(72f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(52f, root.getLayoutWidth(), 0.0f);
		assertEquals(52f, root.getLayoutHeight(), 0.0f);
	}

}
