import requests, pandas as pd

url = "https://api.github.com/repos/Pat2761/European-Baseball-scoresheet-tool/issues"
params = {"state": "all", "per_page": 100, "page": 1}
rows = []
while True:
    r = requests.get(url, params=params).json()
    if not r:
        break
    rows += [i for i in r if "pull_request" not in i]
    params["page"] += 1

df = pd.DataFrame([{
    "numéro": i["number"],
    "titre": i["title"],
    "état": i["state"],
    "auteur": i["user"]["login"],
    "labels": ", ".join(l["name"] for l in i["labels"]),
    "assignés": ", ".join(a["login"] for a in i["assignees"]),
    "créée": i["created_at"],
    "fermée": i["closed_at"],
    "url": i["html_url"],
} for i in rows])
df.to_excel("issues.xlsx", index=False)
