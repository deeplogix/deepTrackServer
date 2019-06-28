Ext.define('Traccar.view.permissions.LogReport', {
    extend: 'Traccar.view.permissions.Base',
    xtype: 'linkLogReportView',

    columns: {
        items: [{
            text: 'Id',
            dataIndex: 'name',
            flex: 1,
            minWidth: Traccar.Style.columnWidthNormal,
            filter: 'string'
        }, {
            text: 'Type',
            dataIndex: 'type',
            flex: 1,
            minWidth: Traccar.Style.columnWidthNormal,
            filter: {
                type: 'list',
                idField: 'key',
                labelField: 'name',
                store: 'MaintenanceTypes'
            },
            renderer: function (value) {
                var attribute = Ext.getStore('MaintenanceTypes').getById(value);
                return attribute && attribute.get('name') || value;
            }
        }, {
            text: 'Message',
            dataIndex: 'start',
            flex: 1,
            minWidth: Traccar.Style.columnWidthNormal,
            renderer: function (value, metaData, record) {
                return Traccar.AttributeFormatter.renderAttribute(
                    value, Ext.getStore('MaintenanceTypes').getById(record.get('type')));
            }
        }, {
            text: 'Time',
            dataIndex: 'period',
            flex: 1,
            minWidth: Traccar.Style.columnWidthNormal,
            renderer: function (value, metaData, record) {
                return Traccar.AttributeFormatter.renderAttribute(
                    value, Ext.getStore('MaintenanceTypes').getById(record.get('type')));
            }
        }]
    }
});
