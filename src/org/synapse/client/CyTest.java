package org.synapse.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CyTest implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Button btn = new Button("Init Cytoscape");
		btn.addClickHandler(new ClickHandler() {					
			@Override
			public void onClick(ClickEvent event) {
				initCytoscape("cy");						
			}
		});
		RootPanel.get("buttonContainer").add(btn);
	}

	/**
	 * JSNI method to init Cytoscape with the given container 
	 * @param containerId
	 */
	private static native void initCytoscape(String containerId) /*-{
		
		$wnd.jQuery('#'+containerId).cytoscape({
		  style: $wnd.cytoscape.stylesheet()
		    .selector('node')
		      .css({
		        'content': 'data(name)',
		        'text-valign': 'center',
		        'color': 'white',
		        'text-outline-width': 2,
		        'text-outline-color': '#888'
		      })
		    .selector('edge')
		      .css({
		        'target-arrow-shape': 'triangle'
		      })
		    .selector(':selected')
		      .css({
		        'background-color': 'black',
		        'line-color': 'black',
		        'target-arrow-color': 'black',
		        'source-arrow-color': 'black'
		      })
		    .selector('.faded')
		      .css({
		        'opacity': 0.25,
		        'text-opacity': 0
		      }),
		  
		  elements: {
		    nodes: [
		      { data: { id: 'j', name: 'Jerry' } },
		      { data: { id: 'e', name: 'Elaine' } },
		      { data: { id: 'k', name: 'Kramer' } },
		      { data: { id: 'g', name: 'George' } }
		    ],
		    edges: [
		      { data: { source: 'j', target: 'e' } },
		      { data: { source: 'j', target: 'k' } },
		      { data: { source: 'j', target: 'g' } },
		      { data: { source: 'e', target: 'j' } },
		      { data: { source: 'e', target: 'k' } },
		      { data: { source: 'k', target: 'j' } },
		      { data: { source: 'k', target: 'e' } },
		      { data: { source: 'k', target: 'g' } },
		      { data: { source: 'g', target: 'j' } }
		    ]
		  },
		  
		  ready: function(){
		    $wnd.cy = this;
		    
		    // giddy up...
		    
		    cy.elements().unselectify();
		    
		    cy.on('tap', 'node', function(e){
		      var node = e.cyTarget; 
		      var neighborhood = node.neighborhood().add(node);
		      
		      cy.elements().addClass('faded');
		      neighborhood.removeClass('faded');
		    });
		    
		    cy.on('tap', function(e){
		      if( e.cyTarget === cy ){
		        cy.elements().removeClass('faded');
		      }
		    });
		  }
		});
				
			
	}-*/;

}
