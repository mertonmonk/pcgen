/*
 * Copyright (c) 2006, 2009.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2.0 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 * 
 * Created on Mar 10, 2006
 */
package pcgen.gui.converter.event;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import pcgen.cdom.base.CDOMObject;
import pcgen.rules.context.LoadContext;

public class TokenProcessEvent extends EventObject
{

	private final LoadContext context;
	private final String key;
	private final String value;
	private final CDOMObject obj;
	private StringBuilder result = new StringBuilder();
	private boolean consumed = false;
	private List<CDOMObject> injected;

	public TokenProcessEvent(LoadContext lc, String tokenName,
			String tokenValue, CDOMObject object)
	{
		super(object);
		key = tokenName;
		value = tokenValue;
		obj = object;
		context = lc;
	}

	public void consume()
	{
		consumed = true;
	}

	public boolean isConsumed()
	{
		return consumed;
	}

	public String getKey()
	{
		return key;
	}

	public String getValue()
	{
		return value;
	}

	public void append(CharSequence s)
	{
		result.append(s);
	}

	public void append(char c)
	{
		result.append(c);
	}

	public CDOMObject getPrimary()
	{
		return obj;
	}

	public String getResult()
	{
		return result.toString();
	}

	public LoadContext getContext()
	{
		return context;
	}

	public void inject(CDOMObject cdo)
	{
		if (injected == null)
		{
			injected = new ArrayList<CDOMObject>();
		}
		injected.add(cdo);
	}

	public List<CDOMObject> getInjected()
	{
		return injected == null ? null : new ArrayList<CDOMObject>(injected);
	}
}
