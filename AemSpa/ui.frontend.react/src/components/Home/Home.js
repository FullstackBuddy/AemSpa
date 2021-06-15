import React, { Component } from 'react';
import {MapTo} from '@adobe/aem-react-editable-components';
import ./Home/Home.css

const HomeEditConfig = {

    emptyLabel: 'Home',
    isEmpty: function(props) {
        return !props || !props.label || !props.urlPath;
    }
};

/**
 * Home React component
 */
class Home extends Component {

    render() {
        if(HomeEditConfig.isEmpty(this.props)) {
                return null;
            } else {
                return <div>
                            <div>Link Label = {this.props.label}</div>
                            <div> Link URL = {this.props.urlPath} </div>
                        </div>
            }
    }
}

export default MapTo('AemSpa/components/home')(Home, HomeEditConfig);