package org.xbib.elasticsearch.plugin.arrayformat

import org.elasticsearch.plugins.AbstractPlugin
import org.elasticsearch.rest.RestModule
import org.xbib.elasticsearch.rest.arrayformat.ArrayformatRestSearchAction

class ArrayformatPlugin extends AbstractPlugin {

    @Override
    String name() {
        return "arrayformat-plugin"
    }

    @Override
    String description() {
        return "REST arrayformat plugin"
    }

    void onModule(RestModule module) {
        module.addRestAction(ArrayformatRestSearchAction.class)
    }

    public static void main() {
        println new ArrayformatPlugin().description()
    }
}