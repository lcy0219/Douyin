import openai

def review_code(code):
    prompt = f"Review the following code snippet:\n\n{code}\n\nProvide feedback on code quality, potential errors, and suggestions for improvement."
    response = openai.Completion.create(
        engine="code-davinci-002",
        prompt=prompt,
        max_tokens=150
    )
    return response.choices[0].text.strip()

code_snippet = """
def example_function(x, y):
    return x + y
"""
result = review_code(code_snippet)
print(result)  # 输出结果
