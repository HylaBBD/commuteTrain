const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const htmlPageNames = ['index', 'request'];
const multipleHtmlPlugins = htmlPageNames.map(name => {
  return new HtmlWebpackPlugin({
    filename: `${name}.html`, // output HTML files
    chunks: [`${name}`] // respective JS files
  })
});

module.exports = {
    entry: {
        navbar: '/src/navbar.js',
        index: '/src/index.js',
        request: '/src/request.js',
      },
      plugins: multipleHtmlPlugins,
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'dist'),
    clean: true,
  },
  module: {
    rules: [
      {
        test: /\.css$/i,
        use: ['style-loader', 'css-loader'],
      },
    ],
  },
};