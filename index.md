<!-- {% assign pages = site.pages | where_exp: "p", "p.path contains '.md'" | sort: "path" %} {% assign current_folder = "" %}

{% for p in pages %} {% unless p.url == "/" %} {% assign parts = p.path | split: "/" %} {% comment %} Reconstruct the folder path to maintain the nested structure logic {% endcomment %} {% assign folder = p.path | remove: parts.last %}
{% if folder != current_folder %}
  {% if current_folder != "" %}
    </ul></li>
  {% endif %}
  <li>📂 <strong>{{ folder | default: "root" }}</strong>
    <ul>
  {% assign current_folder = folder %}
{% endif %}

<li>
  {% comment %} 
     Using parts.last ensures the filename (e.g., 3Data_Transformation.md) 
     is shown even if there is a # discretization heading inside.
  {% endcomment %}
  <a href="{{ p.url }}">{{ parts.last }}</a>
</li>
{% endunless %} {% endfor %} -->


{% assign pages = site.pages | where_exp: "p", "p.path contains '.md'" | sort: "path" %}
{% assign empty_array = "" | split: "," %}
{% assign previous_dir_parts = empty_array %}

<ul>

{% for p in pages %}
  {% assign parts = p.path | split: "/" %}
  {% assign filename = parts.last %}

  {% comment %} Skip index pages or 404s if you want {% endcomment %}
  {% unless filename contains "index" or filename contains "404" %}

    {% comment %} 
       1. Calculate Depth:
       If path is "A/B/file.md", parts.size is 3. Depth of folders is 2 (A, B).
    {% endcomment %}
    {% assign depth = parts.size | minus: 1 %}

    {% comment %} 
       2. Find Common Ancestors:
       Compare current path with the previous one to see how many folders they share.
    {% endcomment %}
    {% assign common_depth = 0 %}
    {% for i in (0..depth) %}
       {% if i == depth or i == previous_dir_parts.size %}
         {% break %}
       {% endif %}
       {% if parts[i] == previous_dir_parts[i] %}
         {% assign common_depth = common_depth | plus: 1 %}
       {% else %}
         {% break %}
       {% endif %}
    {% endfor %}

    {% comment %} 
       3. Close Old Folders:
       If we stepped out of a subfolder, close the tags.
    {% endcomment %}
    {% assign previous_depth = previous_dir_parts.size %}
    {% assign close_count = previous_depth | minus: common_depth %}
    
    {% for i in (1..close_count) %}
        </ul>
        </details>
      </li>
    {% endfor %}

    {% comment %} 
       4. Open New Folders:
       If we stepped into a new subfolder, create the details/summary tags.
    {% endcomment %}
    {% for i in (common_depth..depth) %}
      {% if i == depth %}{% break %}{% endif %}
      {% assign folder_name = parts[i] %}
      <li>
        <details>
          <summary style="cursor: pointer;">📂 <strong>{{ folder_name }}</strong></summary>
          <ul>
    {% endfor %}

    {% comment %} 
       5. Show the File (The missing part!):
    {% endcomment %}
    <li>
      <a href="{{ p.url }}">{{ filename }}</a>
    </li>

    {% comment %} 
       6. Save Current Path for next loop comparison:
    {% endcomment %}
    {% assign current_dir_parts_str = "" %}
    {% for i in (0..depth) %}
      {% if i == depth %}{% break %}{% endif %}
      {% capture current_dir_parts_str %}{{ current_dir_parts_str }},{{ parts[i] }}{% endcapture %}
    {% endfor %}
    {% assign previous_dir_parts = current_dir_parts_str | remove_first: "," | split: "," %}

  {% endunless %}
{% endfor %}

{% comment %} 
   7. Final Cleanup: Close any folders left open at the end. 
{% endcomment %}
{% for i in (1..previous_dir_parts.size) %}
    </ul>
    </details>
  </li>
{% endfor %}

</ul>