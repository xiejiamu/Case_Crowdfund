import { Layout } from 'element-react';
import './App.css';
import 'element-theme-default';

import {BrowserRouter as Router, Route, Routes } from 'react-router-dom'; 

import Caselist from './components/caselist/Caselist';
import Fill from './components/fill/Fill';
import Caseform from './components/caseform/Caseform';

function App() {
  return (
    <div style={{ backgroundColor: 'rgb(5,9,18)', minHeight: '100vh' }}>
    <Router>
      <Layout.Row >
        <Layout.Col span = "4">
          <div style={{minHeight: '100vh'}}></div>
        </Layout.Col>
        <Layout.Col span = "16">
          <div style = {{backgroundColor: 'rgb(27,37,45)'}}>
            <Routes>
              <Route path="/" element = {<Caselist/>} />
              <Route path="fill" element = {<Fill/>} />
              <Route path="form" element = {<Caseform/>}/>
            </Routes>
          </div>
        </Layout.Col>
        <Layout.Col span = "4">
          <div style={{minHeight: '100vh'}}></div>
        </Layout.Col>
      </Layout.Row>
    </Router>
    </div>
  );
}

export default App;
