import api from '../utils/api';

export const getCaseList = (current, pageSize, query) => {
    try {
        return api.post('/submit/list', current, pageSize, query);
    } catch(err) {
        console.log(err);
    }
}.App {
  text-align: center;
}

.App-logo {
  height: 40vmin;
  pointer-events: none;
}

@media (prefers-reduced-motion: no-preference) {
  .App-logo {
    animation: App-logo-spin infinite 20s linear;
  }
}

.App-header {
  background-color: #282c34;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: calc(10px + 2vmin);
  color: white;
}

.App-link {
  color: #61dafb;
}

@keyframes App-logo-spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}

.navbar {
  display: flex;
  .el-menu-demo {
    display: flex;
    width: 100%; /* 确保菜单填充整个容器 */
  }
}

.scoreboard {
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  padding: 20px;
  width: 100%;
}

.score {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 25%;
}

.label {
  font-size: 16px;
  margin-bottom: 8px;
}

.value {
  font-size: 32px;
  font-weight: bold;
}

.divider {
  height: 50px; /* Adjust as per your design */
  border-left: 1px solid #555; /* Lighter/Darker line color as per your design */
  margin: 0 20px; /* Spacing between scores */
}

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
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
import React, {useState} from 'react'
import { Link } from 'react-router-dom';
import { Breadcrumb, Pagination, Table, Input, Button, Steps, Upload } from 'element-react';

const Caseform = () => {
  const [formData, setFormData] = useState({
    casename: '', 
    caseid: '', 
    courtname: '', 
    publish: '', 
    keywords: '', 
    abstract: '', 
    conflictfocus: '', 
    judgepoint: '', 
    lawcase: '', 
    recres: '', 
    article: ''
  });

  const { casename, caseid, courtname, publish, keywords, abstract, conflictfocus, judgepoint, lawcase, recres, article } = formData;

  const onChange = (e) =>
    setFormData({ ...formData, [e.target.name]: e.target.value });

  return (
    <div style={{padding: "1rem"}}>
      <div style={{}}>
        <Breadcrumb separator="/" >
          <Breadcrumb.Item>首页</Breadcrumb.Item>
          <Breadcrumb.Item>案例众筹</Breadcrumb.Item>
          <Breadcrumb.Item>众筹新增</Breadcrumb.Item>
        </Breadcrumb>
        
        <Steps space={200} active={2} style={{display: 'flex', justifyContent: 'center'}}>
          <Steps.Step title="步骤 1"></Steps.Step>
          <Steps.Step title="步骤 2"></Steps.Step>
        </Steps>

        <p style={{color: 'white', display: 'flex', justifyContent: 'center'}}>将案例的简略内容进行填写；第二步，审查系统自动匹配的相关案例要素是否正确；第三步，提交通过审核后获取1个月的免费使用时长。</p>
      </div>

      <div style={{backgroundColor: 'rgb(26,30,35)', padding: '1rem'}}>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '1rem'}}>
          <form
            className="form"
            onSubmit={(e) => {
              e.preventDefault();
              submitCase(formData).then(() => navigate('/'));
            }}
          >
            <p style={{ color: 'white' }}>【基本信息】</p>
              <span>案件名称</span><input
                type="text"
                name="title"
                value={casename}
                onChange={onChange}
                required
              />
              <span>案号</span><input
                type="text"
                name="caseid"
                value={caseid}
                onChange={onChange}
                required
              />
              <span>审理法院信息</span><input
                type="text"
                name="courtname"
                value={courtname}
                onChange={onChange}
                required
              />
              <span>发布机关</span><input
                type="text"
                name="publish"
                value={publish}
                onChange={onChange}
                required
              />
            <p style={{ color: 'white' }}>【关键词】</p>
            <div className="form-group">
              <input
                type="text"
                name="keywords"
                value={keywords}
                onChange={onChange}
                required
              />
            </div>
            <p style={{ color: 'white' }}>【案情摘要】</p>
            <div className="form-group">
              <textarea
                name="abstract"
                cols="30"
                rows="5"
                value={abstract}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【争议焦点】</p>
            <div className="form-group">
              <textarea
                name="conflictfocus"
                cols="30"
                rows="5"
                value={conflictfocus}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【裁判要点】</p>
            <div className="form-group">
              <textarea
                name="judgepoint"
                cols="30"
                rows="5"
                value={judgepoint}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【适用法律】</p>
            <div className="form-group">
              <textarea
                name="lawcase"
                cols="30"
                rows="5"
                value={lawcase}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【推荐理由】</p>
            <div className="form-group">
              <textarea
                name="recres"
                cols="30"
                rows="5"
                value={recres}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【生效文书】</p>
            <div className="form-group">
              <textarea
                name="article"
                cols="30"
                rows="5"
                value={article}
                onChange={onChange}
              />
            </div>
          </form>
        </div>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '2rem'}}>
          <Button><Link to="/fill">上一步</Link></Button>
          <Button type="primary"><Link to="/">提交</Link></Button>
        </div>
      </div>

      <div>
          <p style={{ color: 'white' }}>说明</p>

          <p style={{ color: 'white' }}>众筹范围</p>
          <p style={{ color: 'white' }}>编写案例分析所依据的裁判文书应当为已经在中国裁判文书网公开的裁判文书，原则上应当为2020、2021年度的生效裁判，特别具有典型意义的2019年度生效裁判文书也可作为编写来源。
              未审结的案件不能作为编写来源。</p>

          <p style={{ color: 'white' }}>内容要求</p>
          <p style={{ color: 'white' }}>案例分析文章正文由“标题”、“副标题”、“关键词”、“裁判要旨”、“相关法条”、“案件索引”、“基本案情”、“裁判结果”、“裁判理由”、“案例注解”等部分组成。</p>
          <p style={{ color: 'white' }}>案例注解部分应当重点围绕案件具有指导意义的争议焦点或者分歧意见，充分阐明案例在适用法律解决争议焦点过程中，创造性解释、揭示或阐明新的法律适用规则方面的理念、方法和典型意义。
          具体内容一般包括但不限于：裁判要旨所涉及的法律、司法解释内容和知识；本案所解决的法律争点问题；裁判的思路和方法；本案例的指导意义；类似案例及关联；本案例参照适用中应当注意的问题等。
          分析应当说理充分、严谨、精炼、透彻，用语规范、逻辑严谨，充分揭示案例体现的裁判规则、理念和方法，对类似案件的裁判具有指导、参考和启示意义，展现人民法院的司法智慧和司法成果。
          鼓励分析新型、疑难案件，特别是对各领域中的立法、司法解释制定有参考借鉴价值的案例。</p>
      </div>
    </div>
  )
}

export default Caseform
import React, {useState} from 'react'
import { Link } from 'react-router-dom';
import { Breadcrumb, Pagination, Table, Input, Button, Steps } from 'element-react';
import { getCaseList } from '../../actions/case';

const Caselist = ({getCaseList}) => {

    const data = getCaseList(1, 5, null);
    
    return (
        <div style={{padding: "1rem"}}>
            <div style={{height: '3rem'}}>
                <Breadcrumb separator="/" >
                    <Breadcrumb.Item>首页</Breadcrumb.Item>
                    <Breadcrumb.Item>案例众筹</Breadcrumb.Item>
                    <Breadcrumb.Item>我的众筹</Breadcrumb.Item>
                </Breadcrumb>
            </div>

            <div style={{backgroundColor: 'rgb(26,30,35)', padding: '0rem'}}>

                <div> {/* stats */}
                    <div className="scoreboard">
                        <div className="score">
                            <span className="label">全部众筹</span>
                            <span className="value">data.allcase</span>
                        </div>
                        <div className="divider"></div>
                        <div className="score">
                            <span className="label">审批中</span>
                            <span className="value">data.onprogress</span>
                        </div>
                        <div className="divider"></div>
                        <div className="score">
                            <span className="label">已通过</span>
                            <span className="value">data.passed</span>
                        </div>
                    </div>
                </div>

                <div style={{display: 'flex', alignItems: 'center', padding: '1rem'}}>
                    <span style={{ color: 'white' }}>众筹列表</span>
                    <Button icon="search" style={{marginLeft: '1rem'}}></Button>

                    <Input 
                        style={{width: '7rem', marginLeft: 'auto', display: 'flex'}}
                        icon="search"
                        placeholder="请输入案例名称"
                        onIconClick={this.handleIconClick.bind(this)}
                    />
                </div>

                <div style={{display: 'flex', justifyContent: 'center', padding: '1rem'}}>
                    <Button icon="plus" style={{color: 'black'}}><Link to="/fill"></Link>新增案例</Button>
                </div>

                <div>
                    {data.list.map((item) => (
                        <div key={item.id} className="list-item" style={{display: 'flex', alignItems: 'center', justifyContent: 'space-between', color: 'white', marginLeft: '1rem', marginRight: '1rem'}}>
                            <div className="caseid">{item.id}</div>
                            <div className="casename">{item.casename}</div>
                            <div className="caseusername">{item.username}</div>
                            <div className="casecreated">{item.created}</div>
                        </div>
                    ))}
                </div>

                <div style={{ height: '3rem', margin: '2rem', display: 'flex', justifyContent: 'flex-end' }}>
                    <Pagination layout="prev, pager, next, total, sizes, jumper" total={8} pageSizes={[5, 10, 20, 50]} pageSize={5} currentPage={1}/>
                </div>

            </div>


            <div>
                <p style={{ color: 'white' }}>说明</p>

                <p style={{ color: 'white' }}>众筹范围</p>
                <p style={{ color: 'white' }}>编写案例分析所依据的裁判文书应当为已经在中国裁判文书网公开的裁判文书，原则上应当为2020、2021年度的生效裁判，特别具有典型意义的2019年度生效裁判文书也可作为编写来源。
                    未审结的案件不能作为编写来源。</p>

                <p style={{ color: 'white' }}>内容要求</p>
                <p style={{ color: 'white' }}>案例分析文章正文由“标题”、“副标题”、“关键词”、“裁判要旨”、“相关法条”、“案件索引”、“基本案情”、“裁判结果”、“裁判理由”、“案例注解”等部分组成。</p>
                <p style={{ color: 'white' }}>案例注解部分应当重点围绕案件具有指导意义的争议焦点或者分歧意见，充分阐明案例在适用法律解决争议焦点过程中，创造性解释、揭示或阐明新的法律适用规则方面的理念、方法和典型意义。
                具体内容一般包括但不限于：裁判要旨所涉及的法律、司法解释内容和知识；本案所解决的法律争点问题；裁判的思路和方法；本案例的指导意义；类似案例及关联；本案例参照适用中应当注意的问题等。
                分析应当说理充分、严谨、精炼、透彻，用语规范、逻辑严谨，充分揭示案例体现的裁判规则、理念和方法，对类似案件的裁判具有指导、参考和启示意义，展现人民法院的司法智慧和司法成果。
                鼓励分析新型、疑难案件，特别是对各领域中的立法、司法解释制定有参考借鉴价值的案例。</p>
            </div>
        </div>
    )
}

export default Caselist
import React, {useState} from 'react'
import { Breadcrumb, Steps, Select, Dropdown, Input, Button, Upload } from 'element-react';

const Fill = () => {    
  // 使用useState管理状态
  const [value, setValue] = useState('');
  const options = [
    { value: '选项1', label: '文本填写' },
    { value: '选项2', label: '文件上传' },
  ];
  
  

  return (
    <div style={{padding: "1rem"}}>
      <div style={{}}>
        <Breadcrumb separator="/" >
          <Breadcrumb.Item>首页</Breadcrumb.Item>
          <Breadcrumb.Item>案例众筹</Breadcrumb.Item>
          <Breadcrumb.Item>众筹新增</Breadcrumb.Item>
        </Breadcrumb>
        
        <Steps space={200} active={1} style={{display: 'flex', justifyContent: 'center'}}>
          <Steps.Step title="步骤 1"></Steps.Step>
          <Steps.Step title="步骤 2"></Steps.Step>
        </Steps>

        <p style={{color: 'white', display: 'flex', justifyContent: 'center'}}>将案例的简略内容进行填写；第二步，审查系统自动匹配的相关案例要素是否正确；第三步，提交通过审核后获取1个月的免费使用时长。</p>
      </div>

      <div style={{backgroundColor: 'rgb(26,30,35)', padding: '1rem'}}>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '1rem'}}>
          <span style={{color: 'white'}}>填写方式</span>
          <div style={{width: '5px'}}></div>
          <Select value={value} onChange={setValue} placeholder="文本填写">
            {options.map(el => (
              <Select.Option key={el.value} label={el.label} value={el.value} />
            ))}
          </Select>
        </div>

        <div style={{display: 'flex', justifyContent: 'center'}}>
          <span style={{color: 'white'}}>案例内容</span>
          <div style={{width: '5px'}}></div>
          <div>value=='选项1'?<Upload
            className="upload-demo"
            drag
            value ={content}
            multiple
            tip={<div className="el-upload__tip">支持扩展名：doc .docx .pdf</div>}
          >
            <i className="el-icon-upload"></i>
            <div className="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          </Upload>:<textarea
                name="content"
                cols="30"
                rows="5"
                value={content}
                onChange={onChange} placeholder="请输入内容" />
          </div>
        </div>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '2rem'}}>
          <Button type="primary" onClick={sendCase(content)}><Link to="/form">下一步</Link></Button>
        </div>
      </div>

      <div>
          <p style={{ color: 'white' }}>说明</p>

          <p style={{ color: 'white' }}>众筹范围</p>
          <p style={{ color: 'white' }}>编写案例分析所依据的裁判文书应当为已经在中国裁判文书网公开的裁判文书，原则上应当为2020、2021年度的生效裁判，特别具有典型意义的2019年度生效裁判文书也可作为编写来源。
              未审结的案件不能作为编写来源。</p>

          <p style={{ color: 'white' }}>内容要求</p>
          <p style={{ color: 'white' }}>案例分析文章正文由“标题”、“副标题”、“关键词”、“裁判要旨”、“相关法条”、“案件索引”、“基本案情”、“裁判结果”、“裁判理由”、“案例注解”等部分组成。</p>
          <p style={{ color: 'white' }}>案例注解部分应当重点围绕案件具有指导意义的争议焦点或者分歧意见，充分阐明案例在适用法律解决争议焦点过程中，创造性解释、揭示或阐明新的法律适用规则方面的理念、方法和典型意义。
          具体内容一般包括但不限于：裁判要旨所涉及的法律、司法解释内容和知识；本案所解决的法律争点问题；裁判的思路和方法；本案例的指导意义；类似案例及关联；本案例参照适用中应当注意的问题等。
          分析应当说理充分、严谨、精炼、透彻，用语规范、逻辑严谨，充分揭示案例体现的裁判规则、理念和方法，对类似案件的裁判具有指导、参考和启示意义，展现人民法院的司法智慧和司法成果。
          鼓励分析新型、疑难案件，特别是对各领域中的立法、司法解释制定有参考借鉴价值的案例。</p>
      </div>
    </div>
  )
}

export default Fill
body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

code {
  font-family: source-code-pro, Menlo, Monaco, Consolas, 'Courier New',
    monospace;
}
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import 'element-theme-default';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
const reportWebVitals = onPerfEntry => {
  if (onPerfEntry && onPerfEntry instanceof Function) {
    import('web-vitals').then(({ getCLS, getFID, getFCP, getLCP, getTTFB }) => {
      getCLS(onPerfEntry);
      getFID(onPerfEntry);
      getFCP(onPerfEntry);
      getLCP(onPerfEntry);
      getTTFB(onPerfEntry);
    });
  }
};

export default reportWebVitals;
// jest-dom adds custom jest matchers for asserting on DOM nodes.
// allows you to do things like:
// expect(element).toHaveTextContent(/react/i)
// learn more: https://github.com/testing-library/jest-dom
import '@testing-library/jest-dom';
import axios from 'axios';

// Create an instance of axios
const api = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json'
  }
});

export default api