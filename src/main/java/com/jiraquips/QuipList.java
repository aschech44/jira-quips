package com.jiraquips;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

// For some reason the Jersey stuff won't serialise a List<Quip> on its own - but if you
// make it a field of a class, and stuff it inside, it will serialise that class for you!!
@XmlRootElement
class QuipList
{
	public QuipList()
	{
	}
	
	public QuipList(List<Quip> quips, boolean canDelete)
	{
		Collections.sort(quips);
		this.quips = quips;
		this.canDelete = canDelete;
	}
	
	@XmlElement
	private boolean canDelete;
	
	@XmlElement
	private List<Quip> quips;
}
