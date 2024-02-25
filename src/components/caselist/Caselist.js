import React, {useState} from 'react'
import { Breadcrumb, Pagination, Table, Input, Button } from 'element-react';

const Caselist = () => {
    const data = [
        { id: 8, title: 'Some title 8', description:'', owner: '张云龙', date: '2023-06-16 14:03', status: 'completed' },
        { id: 7, title: 'Some title 7', description:'', owner: 'Owner', date: '2023-06-16 14:03', status: 'completed' },
      ];
    
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
                            <span className="value">8</span>
                        </div>
                        <div className="divider"></div>
                        <div className="score">
                            <span className="label">审批中</span>
                            <span className="value">0</span>
                        </div>
                        <div className="divider"></div>
                        <div className="score">
                            <span className="label">已通过</span>
                            <span className="value">8</span>
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
                        // onIconClick={this.handleIconClick.bind(this)}
                    />
                </div>

                <div style={{display: 'flex', justifyContent: 'center', padding: '1rem'}}>
                    <Button icon="plus" style={{color: 'black'}}>新增案例</Button>
                </div>

                <div>
                    {data.map((item) => (
                        <div key={item.id} className="list-item" style={{display: 'flex', alignItems: 'center', justifyContent: 'space-between', color: 'white', marginLeft: '1rem', marginRight: '1rem'}}>
                            <div className="title">{item.title}</div>
                            <div className="owner">{item.owner}</div>
                            <div className="date">{item.date}</div>
                            <div className="status">{item.status === 'completed' ? '✅' : '⏳'}</div>
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
