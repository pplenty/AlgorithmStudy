
/**
 * @author yusik
 * @date 03/18/2018
 * react styling
 */

var destination = document.querySelector('#container');

var squareWidth = 110;
var squareHeight = 140;
var labelHeight = 40;


// version 16부터 class
class Square extends React.Component {
    render() {

        var squareStyle = {
            width: squareWidth,
            height: squareHeight,
            backgroundColor: this.props.bgcolor,
            display: "inline-block",
            textAlign: "center"
        };

        return (
            <div style={squareStyle}>
                {this.props.children}
            </div>
        );
    }
}
class Card extends React.Component {
    render() {

        var cardStyle = {
            width: squareWidth,
            height: squareHeight - labelHeight,
            backgroundColor: this.props.bgcolor,
            display: "inline-block",
            textAlign: "center"
        };

        return (
            <div style={cardStyle}>
                {this.props.children}
            </div>
        );
    }
}
class Label extends React.Component {
    render() {

        var labelStyle = {
            width: squareWidth,
            height: labelHeight,
            backgroundColor: this.props.bgcolor,
            textAlign: "center",
            verticalAlign: "middle",
            lineHeight: labelHeight + 'px',
            fontSize: 20
        };

        return (
            <div style={labelStyle}>
                {this.props.children}
            </div>
        );
    }
}
//
// var Buttonify = React.createClass({
//     render: function() {
//         return (
//             <div>
//                 <button type={this.props.behavior}> {this.props.children} </button>
//             </div>
//         );
//     }
// });

var color = '#58B3FF';
ReactDOM.render(
    <div>
        <Square bgcolor={color}>
            <Card></Card>
            <Label bgcolor="#FFF">{color}</Label>
        </Square>
    </div>
    , destination
);