import React, { useState } from 'react';

const State2 = (props) => {

    // props : 부모로부터 전달받은 값을 저장한 객체
    // props.init

    // const [count, setCount] = useState(0);
    const [count, setCount] = useState(props.init);
    
    // useState : 컴포넌트의 상태를 관리할 때 사용하는 Hook
    // const [변수, 값을 변경하는 함수(setter))] = useState(초기값);

    return (
        <div>
            <h3>{count}</h3>
            <button onClick={() => setCount(count + 1)}>클릭하면 Count 1 증가</button>
        </div>
    );
}

export default State2;