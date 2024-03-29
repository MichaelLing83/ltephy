package gui;

/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
//package org.eclipse.swt.snippets;

/* 
 * example snippet: Hello World
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleControlAdapter;
import org.eclipse.swt.accessibility.AccessibleControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class GuiMain {

	final static String[]	ITEM_NAMES	= { "first item", "second", "third",
			"fourth", "fifth"			};

	static Image getStateImage(Display display, boolean checked) {
		Image image = new Image(display, 16, 16);
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
		gc.fillOval(0, 0, 16, 16);
		if (checked) {
			gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_GREEN));
			gc.drawLine(0, 0, 16, 16);
			gc.drawLine(16, 0, 0, 16);
		}
		gc.dispose();
		return image;
	}

	public static void main(String[] args) {
		Display display = new Display();
		final Image checkedImage = getStateImage(display, true);
		final Image uncheckedImage = getStateImage(display, false);

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		final Table table = new Table(shell, SWT.FULL_SELECTION | SWT.BORDER);
		for (int i = 0; i < ITEM_NAMES.length; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(ITEM_NAMES[i]);
			item.setImage(i % 2 == 0 ? checkedImage : uncheckedImage);
		}
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				TableItem item = (TableItem) e.item;
				item.setImage(item.getImage() == checkedImage ? uncheckedImage
						: checkedImage);
			}
		});

		table.getAccessible().addAccessibleControlListener(
				new AccessibleControlAdapter() {
					@Override
					public void getRole(AccessibleControlEvent e) {
						e.detail = ACC.ROLE_CHECKBUTTON;
					}

					@Override
					public void getState(AccessibleControlEvent e) {
						if (e.childID >= 0 && e.childID < table.getItemCount()) {
							TableItem item = table.getItem(e.childID);
							if (item.getImage() == checkedImage) {
								e.detail |= ACC.STATE_CHECKED;
							}
						}
					}
				});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		checkedImage.dispose();
		uncheckedImage.dispose();
		display.dispose();
	}
}
